public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int res=0;
        if(grid.length==0)
            return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    help(i,j,grid);
                }
            }
        }

        return res;
    }
    private void help(int r,int c,char[][] grid){

        grid[r][c]=0;
        if(r+1<grid.length&&grid[r+1][c]=='1'){
            help(r+1,c,grid);
        }
        if(r-1>=0&&grid[r-1][c]=='1'){
            help(r-1,c,grid);
        }
        if(c-1>=0&&grid[r][c-1]=='1'){
            help(r,c-1,grid);
        }
        if(c+1<grid[0].length&&grid[r][c+1]=='1'){
            help(r,c+1,grid);
        }

    }
}
