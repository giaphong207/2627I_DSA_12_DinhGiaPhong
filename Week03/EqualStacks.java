package Week03;

import java.util.Scanner;

public class EqualStacks {
    //tổng các phần tử của mảng = chiều cao ban đầu của chồng
    static int sum(int[] a) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        return total;
    }
    static int equalStacks(int[] a, int[] b, int[] c) {
        int h1 = sum(a), h2 = sum(b), h3 = sum(c); //chiều cao hiện tại
        int i1 = 0, i2 = 0, i3 = 0;  //chỉ số đỉnh hiện tại
        while (true) {
            if (h1 == h2 && h2 == h3) return h1;
            //return 0 vì có chồng bị bỏ hết không thể bằng nhau ở mức dương
            if (h1 == 0 || h2 == 0 || h3 == 0) return 0;
            //bỏ hình trụ đỉnh của chồng đang cao nhất
            if (h1 >= h2 && h1 >= h3) {
                h1 -= a[i1];
                i1++; //chỉ số đỉnh mới
            } else if (h2 >= h1 && h2 >= h3) {
                h2 -= b[i2];
                i2++;
            } else {
                h3 -= c[i3];
                i3++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
        int[] a = new int[n1], b = new int[n2], c = new int[n3];
        for (int i = 0; i < n1; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++) b[i] = sc.nextInt();
        for (int i = 0; i < n3; i++) c[i] = sc.nextInt();
        System.out.println(equalStacks(a, b, c));
        sc.close();
    }
}