import java.util.Scanner;

public class InsertionSortPart1 { //Bài 3
    public static void insertionSort1(int n, int[] arr) {
        int e = arr[n - 1]; //lưu phần tử cuối cần chèn
        int j = n - 2; //j bắt đầu từ phần tử ngay trước e
        while (j >= 0 && arr[j] > e) { //bắt đầu dịch sang phải
            arr[j + 1] = arr[j];
            printArray(arr); //in sau mỗi lần dịch
            j--;
        }
        //Đặt e vào ô trống rồi in lần cuối
        arr[j + 1] = e;
        printArray(arr);
    }
    public static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int v : arr) {
            sb.append(v).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        insertionSort1(n, arr);
    }
}
