public class 零钱兑换 {

    public static int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        for(int i=1;i<amount+1;i++){
            int min=Integer.MAX_VALUE;
            for(int c:coins){
                if(c==i){
                    min=1;
                    break;
                }
                if(c<i&&dp[i-c]!=Integer.MAX_VALUE){
                    min=Math.min(min,dp[i-c]+1);
                }
            }
            dp[i]=min;


        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }


}
