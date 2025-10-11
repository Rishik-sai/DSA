public class rotatelinkedlist {
    static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        int c=1;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
            c++;
        }
        temp.next=head;
        temp=head;
        k=k%c;
        k=c-k;
        int i=0;
        while(i<k-1){
            temp=temp.next;
            i++;
        }
        head=temp.next;
        temp.next=null;
        return head;
    }
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int k = 2;
        head = rotateRight(head, k);
        printList(head);
    }
}
