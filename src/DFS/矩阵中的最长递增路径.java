package DFS;

public class 矩阵中的最长递增路径 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int[][] lalala=new int[matrix.length][matrix[0].length];
        int res=0;
        boolean[][] visit=new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                res=Math.max(res,dfs(matrix,i,j,visit,Integer.MIN_VALUE,lalala));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix,int i,int j,boolean[][] visit,int target,int[][] lalala){
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||visit[i][j]||matrix[i][j]<=target){
            return 0;
        }
        if(lalala[i][j]!=0){
            return lalala[i][j];
        }
        visit[i][j]=true;
        int temp=matrix[i][j];
        int res=0;
        res=Math.max(res,dfs(matrix,i+1,j,visit,temp,lalala));
        res=Math.max(res,dfs(matrix,i-1,j,visit,temp,lalala));
        res=Math.max(res,dfs(matrix,i,j+1,visit,temp,lalala));
        res=Math.max(res,dfs(matrix,i,j-1,visit,temp,lalala));
        visit[i][j]=false;
        lalala[i][j]=res+1;
        return res+1;
    }
}
