package 动态规划;

import java.util.Arrays;

public class 自由之路 {
    public int findRotateSteps(String ring, String key) {
        char[] sring = ring.toCharArray();
        char[] skey = key.toCharArray();
        int[][] dp = new int[key.length()][ring.length()];
        for(int i = 0 ; i < dp.length ; i ++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int n = ring.length();
        int count = Integer.MAX_VALUE;
        for(int i = 0 ; i < skey.length ; i ++) {
            for(int j = 0 ; j < n; j ++){
                if(skey[i] == sring[j]){
                    if(i == 0)
                        dp[i][j] = Math.min(j, n - j);
                    else{
                        for(int k = 0 ; k < n ; k ++){
                            if(dp[i - 1][k] != Integer.MAX_VALUE){
                                dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)));
                            }
                        }
                    }

                    if(i == skey.length - 1)
                        count = Math.min(count, dp[i][j]);
                }
            }
        }
        return count + skey.length;
    }
}
