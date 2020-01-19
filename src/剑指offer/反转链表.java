package 剑指offer;

public class 反转链表 {


    public ListNode ReverseList(ListNode head) {

        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode listNode=ReverseList(head.next);
        head.next.next=head;
        head.next=null;
        return listNode;


    }

    private ListNode help(ListNode head){
        ListNode pre=null;

        if(head==null||head.next==null) {
            return head;
        }
        ListNode cur=head;
        ListNode next=cur.next;

        while(next!=null)
        {
            cur.next=pre;
            pre=cur;
            cur=next;
            next=cur.next;
        }
        cur.next=pre;
        return cur;
    }


}
