package 链表;

public class k个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode res=new ListNode(0);
        res.next=head;
        ListNode pre=res;
        while(head!=null){
            for(int i=0;i<k-1;i++){
                ListNode nex = head.next;
                if(nex!=null) {
                    head.next = nex.next;
                    nex.next = pre.next;
                    pre.next = nex;
                }else{
                    pre.next=help(pre.next);
                    return res.next;
                }
            }
            pre=head;
            head=head.next;

        }
        return res.next;
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
