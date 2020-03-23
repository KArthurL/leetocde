package 动态规划;

public class 删除与获得点数 {
    public int deleteAndEarn(int[] nums) {
        int[] count=new int[100001];
        for(int n:nums){
            count[n]++;
        }
        int[] dp=new int[100001];
        dp[1]=count[1];
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-2]+count[i]*i,dp[i-1]);
        }
        return dp[100000];
    }
}
