public class 最佳买卖股票时机含冷冻期 {

    public static void main(String[] args) {
        int[] nums={1,2,3,0,2};
        System.out.println(maxProfit(nums));
    }


    public static int maxProfit(int[] prices) {

        if(prices.length<2){
            return 0;
        }
        int[][] dp=new int[prices.length+1][2];
        dp[0][0]=0;
        dp[0][1]=Integer.MIN_VALUE;
        dp[1][0]=0;
        dp[1][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i+1][0]=Math.max(dp[i][0],dp[i][1]+prices[i]);
            dp[i+1][1]=Math.max(dp[i][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length][0];
    }



}
