public class removenthnodefromendll {
    static Node deletennode(Node list, int n) {
        Node fast = list;
        for(int i=0;i<3;i++){
            fast = fast.next;
        }
        Node slow = list;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next=slow.next.next;
        return list;
    }
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);

        System.out.print("First sorted linked list: ");
        printLinkedList(list);

        Node deletedlist = deletennode(list,3);

        System.out.print("Merged sorted linked list: ");
        printLinkedList(deletedlist);
    }
}
