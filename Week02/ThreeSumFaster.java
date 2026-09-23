package Week02; //Bài 1.4.15

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Arrays;

public class ThreeSumFaster {
    //Điều kiện: Mảng a[] đã được sắp xếp tăng dần
    //TwoSumFaster: Đếm số cặp (lo, hi) trong đoạn a[start .. n-1] sao cho a[lo] + a[hi] == target
    private static int twoSumFaster(int[] a, int start, int target) {
        int lo = start;
        int hi = a.length - 1;
        int count = 0;
        while (lo < hi) {
            int sum = a[lo] + a[hi];
            if (sum < target) {
                lo++;
            }
            else if (sum > target) {
                hi--;
            }
            else {
                count++;
                lo++;
                hi--;
            }
        }
        return count;
    }
    //Đếm số bộ ba (i, j, k) với i < j < k sao cho a[i] + a[j] + a[k] == 0
    public static int count(int[] a) { //O(N^2)
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        //Chỉ duyệt đến n - 2 vì cần để dành vị trí cho lo và hi
        for (int i = 0; i < n - 2; i++) {
            if (a[i] > 0) break; //Nếu số nhỏ nhất trong bộ 3 đã lớn hơn 0, tổng không thể bằng 0 do mảng đã được sắp xếp tăng dần
            //Tìm cặp (j, k) trong đoạn a[i+1 .. n-1] sao cho tổng bằng -a[i]
            count += twoSumFaster(a, i + 1, -a[i]);
        }
        return count;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        double time = timer.elapsedTime();
        StdOut.println("So bo ba co tong bang 0: " + count);
        StdOut.println("Thoi gian chay: " + time + " giay");
    }
}