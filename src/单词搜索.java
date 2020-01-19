public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int R=board.length;
        if(R==0)
            return false;
        int C=board[0].length;
        boolean[][] flag=new boolean[R][C];
        boolean res=false;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                flag[i][j]=true;
                res=help(i,j,board,flag,word,0);
                flag[i][j]=false;
                if(res){
                    return res;
                }
            }
        }
        return res;
    }
    public boolean help(int x, int y,char[][] board,boolean[][] flag,String word,int index)
    {
        if(board[x][y]!=word.charAt(index))
            return false;
        else{
            if(index==word.length()-1)
                return true;
            else{
                boolean res=false;
                if(x<board.length-1&&!flag[x+1][y]){
                    flag[x+1][y]=true;
                    res=res|| help(x+1,y,board,flag,word,index+1);
                    flag[x+1][y]=false;
                    if(res){
                        return res;
                    }
                }
                if(x>0&&!flag[x-1][y]){
                    flag[x-1][y]=true;
                    res=res|| help(x-1,y,board,flag,word,index+1);
                    flag[x-1][y]=false;
                    if(res){
                        return res;
                    }
                }
                if(y<board[0].length-1&&!flag[x][y+1]){
                    flag[x][y+1]=true;
                    res=res|| help(x,y+1,board,flag,word,index+1);
                    flag[x][y+1]=false;
                    if(res){
                        return res;
                    }
                }
                if(y>0&&!flag[x][y-1]){
                    flag[x][y-1]=true;
                    res=res|| help(x,y-1,board,flag,word,index+1);
                    flag[x][y-1]=false;
                    if(res){
                        return res;
                    }
                }
                return res;
            }
        }
    }
}
