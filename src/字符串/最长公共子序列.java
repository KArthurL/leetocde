package 字符串;

public class 最长公共子序列 {

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0||text2.length()==0){
            return 0;
        }
        if(text1.length()<text2.length()){
            return longestCommonSubsequence(text2,text1);
        }
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(text2.charAt(j-1)==text1.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
