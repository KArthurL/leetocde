package 链表;

public class 旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {

        if(head==null||head.next==null)
            return head;

        ListNode end=null;
        ListNode start=head;
        int len=1;
        while(start.next!=null)
        {
            len++;
            start=start.next;
        }
        end=start;
        start=head;
        k=len-k%len;
        for(int i=1;i<k;i++)
        {
            if(head.next==null)
                head=start;
            else
                head=head.next;

        }
        if(head.next==null)
            return start;
        else
        {
            end.next=start;
            start=head.next;
            head.next=null;

        }
        return start;
    }



}
