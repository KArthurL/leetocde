import java.util.List;

public class 三角形最小路径和 {


    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {


        int res=Integer.MAX_VALUE;
        int[][] dp=new int[triangle.size()][triangle.size()];

        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<=i;j++){
                int temp=triangle.get(i).get(j);
                if(j==0){
                    dp[i][j]=dp[i-1][0]+temp;
                }else if(j==i){
                    dp[i][j]=dp[i-1][j-1]+temp;
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1]+temp,dp[i-1][j]+temp);
                }

            }
        }

        for(int x:dp[triangle.size()-1]){
            res=Math.min(res,x);
        }
        return res;
    }

}
