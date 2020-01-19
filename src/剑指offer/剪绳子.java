package 剑指offer;

public class 剪绳子 {


    public int cutRope(int target) {
        if(target==2) {
            return 1;
        }
        int[] dp=new int[target+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=2;i<=target;i++)
        {
            for(int j=1;j<i;j++) {
                dp[i]=Math.max(dp[i],dp[i-j]*(j));
            }
        }
        return dp[target];



    }
}
