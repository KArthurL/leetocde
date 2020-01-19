package 剑指offer;

public class 删除链表中的重复结点 {

    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)
            return pHead;
        ListNode head=new ListNode(0);
        head.next=pHead;
        ListNode pre=head;
        ListNode last=head.next;
        while(last!=null)
        {
            if(last.next!=null&&last.val==last.next.val)
            {
                while(last.next!=null&&last.val==last.next.val)
                {
                    last=last.next;
                }
                pre.next=last.next;
                last=pre.next;
            }
            else{
                pre=last;
                last=pre.next;
            }
        }
        return head.next;
    }
}
