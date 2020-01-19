public class 最大正方形 {


    public static void main(String[] args) {
        int[][] natrix={
                {1,0,1,0},
                {1,0,1,1},
                {1,1,1,1},
                {1,0,0,1}

        };
        System.out.println(maximalSquare(natrix));
    }

    public static int maximalSquare(int[][] matrix) {


        if(matrix.length==0){
            return  0;
        }
        int res=0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            dp[i][0]=matrix[i][0];
            if(dp[i][0]==1)
                res=1;
        }

        for(int i=0;i<matrix[0].length;i++)
        {
            dp[0][i]=matrix[0][i];
            if(dp[0][i]==1)
                res=1;
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }

        return res*res;
    }

}
