package 剑指offer;

public class 复杂链表的肤质 {
    public ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 完成链表节点的复制
        ListNode cur = head;
        while (cur != null) {
            ListNode copyNode = new ListNode(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }

        // 完成链表复制节点的随机指针复制
        cur = head;
        while (cur != null) {
            if (cur.random != null) { // 注意判断原来的节点有没有random指针
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 将链表一分为二
        ListNode copyHead = head.next;
        cur = head;
        ListNode curCopy = head.next;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (curCopy.next != null) {
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;
            }
        }
        return copyHead;
    }
}
