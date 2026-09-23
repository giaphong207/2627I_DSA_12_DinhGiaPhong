package Week02; //Bài 1.4.17

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class FarthestPair {
    //Độ phức tạp: O(N)
    public static double[] farthestPair(double[] a) {
        if (a == null || a.length < 2) {
            throw new IllegalArgumentException("Mang phai co it nhat 2 phan tu");
        }
        double min = a[0];
        double max = a[0];
        //Duyệt mảng 1 lần duy nhất để tìm min max
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] > max) max = a[i];
        }
        return new double[] { min, max };
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        double[] a = in.readAllDoubles();
        double[] pair = farthestPair(a);
        double min = pair[0];
        double max = pair[1];
        StdOut.println("Cap xa nhat: (" + min + ", " + max + ")");
        StdOut.println("Hieu 2 so: " + (max - min));
    }
}
