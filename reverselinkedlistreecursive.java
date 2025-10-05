public class reverselinkedlistreecursive {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head;
    static Node reverseRecursive(Node head) {
        // Base case: if head is null or only one node, it's reversed
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        Node newHead = reverseRecursive(head.next);

        // Make the next node point to the current node
        head.next.next = head;
        head.next = null; // Set the next of current node to null

        return newHead; // New head of the reversed list
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        head = reverseRecursive(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }
}
