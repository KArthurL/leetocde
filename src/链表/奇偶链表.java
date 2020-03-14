package 链表;

import java.util.List;

public class 奇偶链表 {

    public ListNode oddEvenList(ListNode head) {


        ListNode res=new ListNode(0);
        ListNode ou=new ListNode(0);
        ListNode q=ou;
        ListNode p=res;
        int index=0;
        while(head!=null){
            if((index++&1)==0){
                p.next=head;
                p=p.next;
            }else{
                q.next=head;
                q=q.next;
            }
            ListNode temp=head.next;
            head.next=null;
            head=temp;
        }
        p.next=ou.next;
        return res.next;
    }
}
