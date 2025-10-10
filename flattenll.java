class Node1 {
    int data;
    Node1 next;
    Node1 child;

    Node1(int x) {
        this.data = x;
        this.next = null;
        this.child = null;
    }
}

public class flattenll {
    static Node1 merge(Node1 list1, Node1 list2) {
        Node1 dummyNode1 = new Node1(-1);
        Node1 res = dummyNode1;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }
        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }
        if (dummyNode1.child != null) {
            dummyNode1.child.next = null;
        }
        return dummyNode1.child;
    }
    static Node1 flattenLinkedList(Node1 head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node1 mergedHead = flattenLinkedList(head.next);
        head = merge(head, mergedHead);
        return head;
    }
    static void printLinkedList(Node1 head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }
    static void printOriginalLinkedList(Node1 head, int depth) {
        while (head != null) {
            System.out.print(head.data);
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node1 head = new Node1(5);
        head.child = new Node1(14);

        head.next = new Node1(4);
        head.next.child = new Node1(10);

        head.next.next = new Node1(12);
        head.next.next.child = new Node1(13);
        head.next.next.child.child = new Node1(20);

        head.next.next.next = new Node1(7);
        head.next.next.next.child = new Node1(17);
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);
        Node1 flattened = flattenLinkedList(head);
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}


