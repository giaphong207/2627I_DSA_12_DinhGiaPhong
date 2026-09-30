package Week03;

import java.util.Scanner;

public class QueueUsingTwoStacks {
    static class IntStack {
        private class Node {
            int item;
            Node next;
        }
        private Node first = null;
        public boolean isEmpty() { //ktra rỗng
            return first == null;
        }
        public void push(int x)  {
            Node oldfirst = first; //lưu đầu cũ
            first = new Node(); //tạo node mới làm đầu
            first.item = x; //bỏ dữ liệu vào
            first.next = oldfirst; //nối tới đầu cũ
        }
        public int pop() {
            int x = first.item; //lưu dữ liệu ở đầu
            first = first.next;  //dời đầu sang node kế
            return x; //trả dữ liệu đã lưu
        }
        public int peek() { //xem phần tử ở đỉnh mới nhất và không xoá
            return first.item;
        }
    }
    static class MyQueue {
        private IntStack inbox = new IntStack(); //inbox chứa các phần tử chưa sắp xếp theo đúng queue vào đầu ở cuối
        private IntStack outbox = new IntStack(); //chuyển từ inbox sang outbox nên đã đúng thứ tự của queue
        //đổ inbox sang outbox
        private void shift() {
            // điền: nếu outbox rỗng thì
            //       lặp cho đến khi inbox rỗng: pop từ inbox, push vào outbox
            if (outbox.isEmpty()) {
                while (!inbox.isEmpty()) {
                    int k = inbox.pop();
                    outbox.push(k);
                }
            }
        }
        public void enqueue(int x) { //thêm vào cuối
            inbox.push(x);
        }
        public int dequeue() { //lấy phần tử đầu
            shift();
            return outbox.pop();
        }
        public int peek() {
            shift();
            return outbox.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        MyQueue queue = new MyQueue();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                queue.enqueue(x);
            } else if (type == 2) {
                queue.dequeue();
            } else {
                System.out.println(queue.peek());
            }
        }
        sc.close();
    }
}