public class 最长上升子序列 {

    public int lengthOfLIS(int[] nums) {
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
