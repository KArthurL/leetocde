package 剑指offer;

public class 合并排序列表 {

    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode res=null;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        if(list1.val>list2.val)
        {
            res=list2;
            res.next=Merge(list1,list2.next);
        }

        else
        {
            res=list1;
            res.next=Merge(list1.next,list2);
        }

        return res;
    }
}
