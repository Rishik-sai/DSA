import java.util.Stack;
public class queueusingstack {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void enqueue(int x) {
        input.push(x);
    }

    public int dequeue() {
        if (input.isEmpty() && output.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public int peek() {
        if (input.isEmpty() && output.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {
        queueusingstack q = new queueusingstack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.peek());    
        System.out.println(q.dequeue()); 
        System.out.println(q.peek());    
        System.out.println(q.isEmpty());
    }
}
