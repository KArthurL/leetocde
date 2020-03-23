package 动态规划;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;

import java.util.Arrays;
import java.util.Comparator;

public class 俄罗斯套娃问题 {
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });
        int[] nums=new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            nums[i]=envelopes[i][1];
        }
      return lengthOfLIS(nums);

    }
    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] dp=new int[nums.length];
        int res=1;
        for(int i=0;i<nums.length;i++)
        {
            int max=0;
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                    max=Math.max(dp[j],max);
            }
            dp[i]=max+1;
            res=Math.max(dp[i],res);
        }
        return res;
    }
}
