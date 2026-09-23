package Week02; //Bài 1.4.22

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FibonacciSearch {
    //Độ phức tạp: O(log N)
    //Bộ nhớ phụ: O(1)
    public static boolean contains(int[] a, int key) {
        int n = a.length;
        if (n == 0) return false;
        //Tìm số fibonacci nhỏ nhất >= n
        int fib2 = 0;
        int fib1 = 1;
        int fibM = fib2 + fib1;
        while (fibM < n) {
            fib2 = fib1;
            fib1 = fibM;
            fibM = fib2 + fib1;   //chỉ dùng phép cộng
        }
        //Tìm kiếm chính
        int offset = -1;
        while (fibM > 1) {
            int i = offset + fib2;
            if (i > n - 1) {
                i = n - 1;
            }
            if (a[i] > key) {
                //mảng giảm dần: a[i] > key => key nằm sau vị trí i
                fibM = fib1;
                fib1 = fib2;
                fib2 = fibM - fib1;   //chỉ dùng phép trừ
                offset = i;
            }
            else if (a[i] < key) {
                //mảng giảm dần: a[i] < key => key nằm trước vị trí i
                fibM = fib2;
                fib1 = fib1 - fib2;
                fib2 = fibM - fib1;
            }
            else {
                return true;
            }
        }
        if (fib1 == 1 && offset + 1 < n && a[offset + 1] == key) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        //nhập từ bàn phím
        int n = StdIn.readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdIn.readInt();
        }
        int key = StdIn.readInt();
        boolean found = contains(a, key);
        if (found) {
            StdOut.println("Mang CO chua gia tri " + key);
        }
        else {
            StdOut.println("Mang KHONG chua gia tri " + key);
        }
    }
}
