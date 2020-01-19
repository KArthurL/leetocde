package 链表;

public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res=new ListNode(0);
        ListNode head=res;
        boolean flag=false;
        while(l1!=null&&l2!=null){
            int n=l1.val+l2.val;
            if(flag){
                n++;
            }
            if(n>=10){
                flag=true;
                n=n%10;
            }else {
                flag=false;
            }
            head.next=new ListNode(n);
            head=head.next;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null){
            while(flag){
                if(l2==null){
                    head.next=new ListNode(1);
                    head=head.next;
                    flag=false;
                    break;
                }else{
                    int n=l2.val+1;
                    if(n>=10){
                        n=0;
                        head.next=new ListNode(0);
                        head=head.next;
                        head=head.next;
                        l2=l2.next;
                    }else{
                        head.next=new ListNode(n);
                        head=head.next;
                        l2=l2.next;
                        flag=false;
                        break;
                    }
                }
            }
            head.next=l2;
        }
        if(l2==null){
            while(flag){
                if(l1==null){
                    head.next=new ListNode(1);
                    break;
                }else{
                    int n=l1.val+1;
                    if(n>=10){
                        n=0;
                        head.next=new ListNode(0);
                        head=head.next;
                        l1=l1.next;
                    }else{
                        head.next=new ListNode(n);
                        head=head.next;
                        l1=l1.next;
                        break;
                    }
                }
            }
            head.next=l1;
        }
            return res.next;

    }
}
