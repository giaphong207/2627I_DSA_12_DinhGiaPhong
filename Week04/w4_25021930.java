import java.util.Arrays;
import java.util.Scanner;

public class w4_25021930 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a); //sắp xếp tăng dần
        int h = 0;
        for (int k = 1; k <= n; k++) {
            if (a[n - k] >= k) {
                h = k;
            } else {
                break;
            }
        }
        System.out.println(h);
        sc.close();
    }
}
