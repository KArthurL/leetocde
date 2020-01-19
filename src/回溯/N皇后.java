package 回溯;

import java.util.ArrayList;
import java.util.List;

public class N皇后 {


    public static void main(String[] args) {
        N皇后 n=new N皇后();
        System.out.println(n.solveNQueens(3));
    }


   public List<List<String>> solveNQueens(int n) {

        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        int[][] flag=new int[n][n];

        help(0,res,temp,flag);
        return res;

    }

    private void help(int c,List<List<String>> res,List<String> temp ,int[][] flag){

       if(c>=flag.length){
           res.add(new ArrayList<>(temp));
           return;
       }
       StringBuilder stringBuilder=new StringBuilder();
       for(int i=0;i<flag.length;i++){
           if(flag[c][i]==0){
               stringBuilder.append("Q");
               change(c,i,flag);
               for(int j=i+1;j<flag.length;j++){
                   stringBuilder.append(".");
               }
               temp.add(stringBuilder.toString());
               help(c+1,res,temp,flag);
               changeBack(c,i,flag);
               temp.remove(temp.size()-1);
               stringBuilder.delete(i,flag.length);
               stringBuilder.append(".");

           }else{
               stringBuilder.append(".");
           }
       }


    }

    private void change(int x,int y,int[][] flag){


       for(int i=0;i<flag.length;i++){

           flag[x][i]++;
           flag[i][y]++;
       }
       int start=x;
       int end=y;
       while(start>=0&&end>=0){
           flag[start--][end--]++;
       }
       start=x;
       end=y;
       while(start<flag.length&&end<flag.length){
           flag[start++][end++]++;
       }
        start=x;
        end=y;
        while(start>=0&&end<flag.length){
            flag[start--][end++]++;
        }
        start=x;
        end=y;
        while(start<flag.length&&end>=0){
            flag[start++][end--]++;
        }

    }

    private void changeBack(int x,int y,int[][] flag){

       for(int i=0;i<flag.length;i++){
           flag[x][i]--;
           flag[i][y]--;
       }
        int start=x;
        int end=y;
        while(start>=0&&end>=0){
            flag[start--][end--]--;
        }
        start=x;
        end=y;
        while(start<flag.length&&end<flag.length){
            flag[start++][end++]--;
        }
        start=x;
        end=y;
        while(start>=0&&end<flag.length){
            flag[start--][end++]--;
        }
        start=x;
        end=y;
        while(start<flag.length&&end>=0){
            flag[start++][end--]--;
        }
    }



}
