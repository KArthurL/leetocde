package DFS;



public class 岛屿的最大面积 {
    public static int maxAreaOfIsland(int[][] grid) {

        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    res = Math.max(res, dfs(i,j,grid));
                }
            }
        }
        return res;
    }
    public static int  dfs(int i,int j,int[][] grid){
        if(i>=grid.length||i<0||j<0||j>=grid[0].length||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return 1+dfs(i+1,j,grid)+dfs(i-1,j,grid)+dfs(i,j-1,grid)+dfs(i,j+1,grid);

    }

    public static void main(String[] args) {
        int[][] nums={{0,1}};
        System.out.println(maxAreaOfIsland(nums));
    }
}
