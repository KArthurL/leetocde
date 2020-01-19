import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums={0};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> set=new HashSet<>();
        int res=1;
        for(int num:nums){
            set.add(num);
        }
        for(int num:nums){
            if(!set.contains(num-1)){
                int n=num;
                int s=1;
                while(set.contains(n+1)){
                    n++;
                    s++;
                    res=Math.max(res,s);
                }
            }
        }
        return res;
    }
}
