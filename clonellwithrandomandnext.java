class Node2 {
    int data;
    Node2 next;
    Node2 random;
    Node2(int x) {
        this.data = x;
        this.next = null;
        this.random = null;
    }
}
public class clonellwithrandomandnext {
    static void insertCopyInBetween(Node2 head) {
    Node2 temp = head;
    while (temp != null) {
        Node2 nextElement = temp.next;
        Node2 copy = new Node2(temp.data);
        copy.next = nextElement;
        temp.next = copy;
        temp = nextElement;
      }
    }
static void connectRandomPointers(Node2 head) {
    Node2 temp = head;
    while (temp != null) {
        Node2 copyNode = temp.next;
        if (temp.random != null) {
            copyNode.random = temp.random.next;
        } else {
            copyNode.random = null;
        }
        temp = temp.next.next;
    }
}
static Node2 getDeepCopyList(Node2 head) {
    Node2 temp = head;
    Node2 dummyNode = new Node2(-1);
    Node2 res = dummyNode;

    while (temp != null) {
        res.next = temp.next;
        res = res.next;
        temp.next = temp.next.next;
        temp = temp.next;
    }

    return dummyNode.next;
}

static Node2 cloneLL(Node2 head) {
    if (head == null) return null;
    insertCopyInBetween(head);
    connectRandomPointers(head);
    return getDeepCopyList(head);
}
static void printClonedLinkedList(Node2 head) {
    while (head != null) {
        System.out.print("Data: " + head.data);
        if (head.random != null) {
            System.out.print(", Random: " + head.random.data);
        } else {
            System.out.print(", Random: null");
        }
        System.out.println();
        head = head.next;
    }
}
public static void main(String[] args) {
    Node2 head = new Node2(7);
    head.next = new Node2(14);
    head.next.next = new Node2(21);
    head.next.next.next = new Node2(28);
    head.random = head.next.next;
    head.next.random = head;
    head.next.next.random = head.next.next.next;
    head.next.next.next.random = head.next;

    System.out.println("Original Linked List with Random Pointers:");
    printClonedLinkedList(head);
    Node2 clonedList = cloneLL(head);

    System.out.println("\nCloned Linked List with Random Pointers:");
    printClonedLinkedList(clonedList);
}
}