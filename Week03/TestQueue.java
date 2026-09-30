package Week03;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        In in = new In("src/Week03/tobe.txt");
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
