package 链表;

public class 删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode res=new ListNode(0);
        res.next=head;
        ListNode pre=res;
        while(pre.next!=null){
            if(pre.next.next!=null&&pre.next.val==pre.next.next.val){
                int x=pre.next.val;
                while(pre.next!=null&&pre.next.val==x){
                    pre.next=pre.next.next;
                }
            }else{
                pre=pre.next;
            }
        }


        return res.next;


    }
}
