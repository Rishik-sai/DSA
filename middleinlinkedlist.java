public class middleinlinkedlist {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head;
    static Node findMiddle(Node head) {
        if (head == null) {
            return null; // If the list is empty, return null
        }

        Node slow = head; // Initialize slow pointer
        Node fast = head; // Initialize fast pointer

        // Move fast pointer two steps and slow pointer one step
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow by one
            fast = fast.next.next;  // Move fast by two
        }

        return slow; // When fast reaches the end, slow will be at the middle
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

        Node middle = findMiddle(head);
        if (middle != null) {
            System.out.println("The middle node is: " + middle.data);
        } else {
            System.out.println("The list is empty.");
        }
    }
}
