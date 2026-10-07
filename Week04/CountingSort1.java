import java.util.Scanner;

public class CountingSort1 { //Bài 7
    public static int[] countingSort(int[] arr) {
        int[] count = new int[100];  //tạo mảng đếm tần sất gồm 100 phần tử
        for (int x : arr) {
            count[x]++; //tăng bộ đếm tại vị trí tương ứng với giá trị x
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = countingSort(arr);
        StringBuilder sb = new StringBuilder(); //in các phần tử cách nhau bằng dấu cách, trên một dòng
        for (int v : result) {
            sb.append(v).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
