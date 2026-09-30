package Week03;

import java.util.Scanner;

public class BalancedBrackets {
    static class CharStack {
        private class Node {
            char item;
            Node next;
        }
        private Node first = null;
        public boolean isEmpty() {
            return first == null;
        }
        public void push(char c) {
            Node oldfirst = first; //lưu đầu cũ
            first = new Node(); //tạo node mới làm đầu
            first.item = c; //bỏ dữ liệu vào
            first.next = oldfirst; //nối tới đầu cũ
        }
        public char pop() {
            char c = first.item; //lưu dữ liệu ở đầu
            first = first.next;  //dời đầu sang node kế
            return c; //trả dữ liệu đã lưu
        }
    }
    //trả về true nếu ch là ngoặc mở
    static boolean isOpen(char ch) {
        return ch == '(' || ch == '[' || ch == '{'; //char dùng ''
    }
    //trả về true nếu open và close là một cặp khớp nhau
    static boolean matches(char open, char close) {
        if (open == '(' && close == ')') return true;
        if (open == '[' && close == ']') return true;
        if (open == '{' && close == '}') return true;
        return false;
    }
    static boolean isBalanced(String s) {
        CharStack stack = new CharStack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpen(c)) {
                stack.push(c);
            } else {
                //nếu stack rỗng thì return false
                if (stack.isEmpty()) return false;  //if (đk)
                //pop ra, nếu không khớp thì return false
                char p = stack.pop();
                if (!matches(p, c)) return false; //p là cái ngoặc mở được pop ra còn c là ngoặc sau đang xét cặp
            }
        }
        //kiểm tra stack rỗng thì true, ngược lại false
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            System.out.println(isBalanced(s) ? "YES" : "NO");
        }
        sc.close();
    }
}
