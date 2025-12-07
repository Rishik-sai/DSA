import java.util.Stack;
public class stacksorting {
    public static void insertSorted(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || stack.peek() <= x) {
            stack.push(x);
            return;
        }

        int temp = stack.pop();
        insertSorted(stack, x);
        stack.push(temp);
    }

    public static void sortStack(Stack<Integer> stack) {
        if (stack.size() <= 1)
            return;

        int temp = stack.pop();
        sortStack(stack);
        insertSorted(stack, temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted stack:   " + stack);
    }
}
