import java.util.LinkedList;
import java.util.TreeMap;

public class 滑动窗口最大值 {

    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(maxSlidingWindow(nums,k));
    }


    public static  int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0){
            return new int[0];
        }
        if(nums.length==1){
            return nums;
        }
        LinkedList<Integer> queue=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(!queue.isEmpty()&&nums[queue.getLast()]<nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        res[0]=nums[queue.getFirst()];
        int index=1;
        for(int i=k;i<nums.length;i++){
            while(!queue.isEmpty()&&queue.getFirst()<=i-k){
                queue.removeFirst();
            }
            while(!queue.isEmpty()&&nums[queue.getLast()]<nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            res[index++]=nums[queue.getFirst()];
        }
        return res;




    }
}
