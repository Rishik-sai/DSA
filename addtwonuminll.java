public class addtwonuminll {
    static Node addtwoll(Node list1,Node list2){
        Node dummy=new Node(0);
        Node p=dummy;
        int carry=0;
        while(list1!=null || list2!=null || carry!=0){
            int sum=carry;
            if(list1!=null){
                sum+=list1.data;
                list1=list1.next;
            }
            if(list2!=null){
                sum+=list2.data;
                list2=list2.next;
            }
            carry=sum/10;
            p.next=new Node(sum%10);
            p=p.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Node list1=new Node(2);
        list1.next=new Node(4);
        list1.next.next=new Node(3);
        Node list2=new Node(5);
        list2.next=new Node(6);
        list2.next.next=new Node(7);
        list2.next.next.next=new Node(9);
        Node result=addtwoll(list1,list2);
        while(result!=null){
            System.out.print(result.data+" ");
            result=result.next;
        }
    }
}
