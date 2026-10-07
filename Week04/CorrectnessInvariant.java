import java.util.Scanner;

public class CorrectnessInvariant { //Bài 6
    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            //điều kiện đúng là j >= 0 để xét cả phần tử A[0]
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }
        printArray(A); //in đúng một lần sau khi sắp xong
    }
    public static void printArray(int[] A) {
        StringBuilder sb = new StringBuilder();
        for (int v : A) {
            sb.append(v).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = sc.nextInt();
        }
        insertionSort(arr);
    }
}