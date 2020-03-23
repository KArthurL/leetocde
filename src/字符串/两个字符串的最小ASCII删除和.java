package 字符串;

public class 两个字符串的最小ASCII删除和 {
    public int minimumDeleteSum(String s1, String s2) {


        if(s1.length()==0||s2.length()==0){
            return 0;
        }
        if(s1.length()<s2.length()){
            return minimumDeleteSum(s2,s1);
        }
        int sum=0;
        for(char c:s1.toCharArray()){
            sum+=c;
        }
        for(char c:s2.toCharArray()){
            sum+=c;
        }
        int max;
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s2.charAt(j-1)==s1.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1]+s1.charAt(i-1);
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        max=dp[s1.length()][s2.length()];
        return sum-max*2;
    }
}
