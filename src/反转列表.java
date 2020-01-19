 class ListNode {
     int val;
     ListNode next;

     ListNode(int x) {
         val = x;
     }
 }
public class 反转列表 {


    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;


/*        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;*/
    }

}
