import java.util.LinkedList;
import java.util.Queue;

public class stackusingsinglequeue {
    private final Queue<Integer> q;

    public stackusingsinglequeue() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        int size = q.size();

        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.remove();
    }

    public int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        stackusingsinglequeue stack = new stackusingsinglequeue();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.top());   // 30
        System.out.println("Pop: " + stack.pop());   // 30
        System.out.println("Top: " + stack.top());   // 20
        System.out.println("Empty: " + stack.empty());// false
    }
}
