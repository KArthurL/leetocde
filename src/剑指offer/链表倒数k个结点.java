package 剑指offer;

public class 链表倒数k个结点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode res=head;
        ListNode fast=head;
        for(int i=0;i<k;i++)
        {
            if(fast!=null)
                fast=fast.next;
            else
                return null;
        }
        while(fast!=null)
        {
            fast=fast.next;
            res=res.next;
        }
        return res;
    }
}
