package 链表;

public class 两两交换链表中的结点 {
    public ListNode swapPairs(ListNode head) {

        ListNode res=new ListNode(0);
        res.next=head;
        ListNode pre=res;
        while(pre.next!=null&&pre.next.next!=null){
            ListNode next=pre.next.next;
            pre.next.next=next.next;
            next.next=pre.next;
            pre.next=next;
            pre=pre.next.next;

        }
        return  res.next;


    }
}
