public class 目标和 {



    public static int findTargetSumWays(int[] nums, int target) {


        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < target || (sum+target)%2 == 1){
            return 0;
        }
        target = (target + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];

            }
        }
        return dp[target];


    }
    public static int help(int[] nums,int index,int s){
        if(index==nums.length) {
            if (s == 0) {
                return 1;
            } else {
                return 0;

            }
        }
        int n1=help(nums,index+1,s+nums[index]);
        int n2=help(nums,index+1,s-nums[index]);
        return n1+n2;
    }
}
