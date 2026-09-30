package Week03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int n;

    public MyQueue() { //ban đầu queue rỗng
        first = null;
        last = null;
        n = 0;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return n;
    }
    public void enqueue(Item item) { //thêm vào cuối queue (sau last)
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
                first = last; //khi rỗng first và last cùng trỏ đến Node mới
        } else {
                oldlast.next = last; //node cũ trỏ đến node mới
        }
        n++;
    }
    public Item dequeue() { //lấy ra ở đầu queue (first)
        if (isEmpty()) throw new NoSuchElementException("Queue is empty"); //ném lỗi khi gọi dequeue mà queue đang rỗng
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args) {
        MyQueue<String> q = new MyQueue<>();
        // Test 1: queue vừa tạo phải rỗng
        System.out.println("Rong luc dau: " + q.isEmpty() + " (mong doi: true)");
        // Test 2: enqueue rồi dequeue đúng thứ tự FIFO
        q.enqueue("to");
        q.enqueue("be");
        q.enqueue("or");
        System.out.println("size = " + q.size() + " (mong doi: 3)");
        System.out.println(q.dequeue() + " (mong doi: to)");
        System.out.println(q.dequeue() + " (mong doi: be)");
        // Test 3: lấy phần tử cuối rồi kiểm tra rỗng
        System.out.println(q.dequeue() + " (mong doi: or)");
        System.out.println("Rong: " + q.isEmpty() + " (mong doi: true)");
        // Test 4: enqueue vào queue vừa rỗng (kiểm tra last = null đã đúng)
        q.enqueue("again");
        System.out.println(q.dequeue() + " (mong doi: again)");
        System.out.println("size = " + q.size() + " (mong doi: 0)");
        // Test 5: dequeue khi rỗng phải ném exception
        try {
            q.dequeue();
            System.out.println("SAI: lieu phai nem exception");
        } catch (NoSuchElementException e) {
            System.out.println("Nem exception dung: " + e.getMessage());
        }

        MyQueue<String> t = new MyQueue<>();
        t.enqueue("to"); t.enqueue("be"); t.enqueue("or");
        for (String s : t) System.out.print(s + " ");   // mong doi: to be or
        System.out.println();
        System.out.println("size sau khi duyet = " + t.size() + " (mong doi: 3)");
    }
}
