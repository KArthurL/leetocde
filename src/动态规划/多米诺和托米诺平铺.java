package 动态规划;

public class 多米诺和托米诺平铺 {
    public static int numTilings(int N) {
        long M=(long)Math.pow(10,9)+7;
        long[] dp=new long[N+1];
        if(N==1){
            return 1;
        }else if(N==2){
            return 2;
        }else if(N==3){
            return 5;
        }
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;
        for(int i=4;i<N+1;i++){
            dp[i]=2*(dp[i-1]%M)+dp[i-3]%M;
        }
        return (int)(dp[N]%M);
    }

    public static void main(String[] args) {
        System.out.println(numTilings(30));
    }
}
