import java.util.Scanner;

public class InsertionSortPart2 { //Bài 5
    public static void insertionSort2(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int e = arr[i]; //lưu phần tử cần chèn
            int j = i - 1; //chỉ số bắt đầu so sánh ngược về trước
            while (j >= 0 && arr[j] > e) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = e;
            printArray(arr);
        }
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
        insertionSort2(n, arr);
    }
}