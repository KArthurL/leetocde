package 数组;

import java.util.*;

public class 查找和最小的k对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<List<Integer>> queue=new PriorityQueue<>((o1, o2) -> o1.get(0)+o1.get(1)-o2.get(0)-o2.get(1));
        if(nums1.length==0||nums2.length==0){
            return res;
        }
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                List<Integer> temp=new ArrayList<>();
                temp.add(nums1[i]);
                temp.add(nums2[j]);
                queue.offer(temp);
            }
        }

        for(int i=0;i<k;i++){
            if(queue.size()>0){
                res.add(queue.poll());
            }else{
                break;
            }

        }
        return res;
    }
}
