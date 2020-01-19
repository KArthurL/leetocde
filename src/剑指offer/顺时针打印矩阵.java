package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 顺时针打印矩阵 {


    public static void main(String[] args) {
        int[][] nums={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(printMatrix(nums));
    }


    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res=new ArrayList<>();

        int r=matrix.length;
        int c=matrix[0].length;
        int min=Math.min(r,c);
        int n=(min-1)/2;
        for(int i=0;i<=n;i++){

            for(int j=i;j<c-n;j++){
                res.add(matrix[i][j]);
            }
            for(int j=i+1;j<r-n;j++){
                res.add(matrix[j][c-i-1]);
            }
            if(i==n&&(min&1)==1){
                break;
            }
            for(int j=c-i-2;j>=i;j--){
                res.add(matrix[r-i-1][j]);
            }
            for(int j=r-i-2;j>i;j--){
                res.add(matrix[j][i]);
            }

        }
        return res;


    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int L=matrix.length;
        if(L==0)
            return res;
        int R=matrix[0].length;
        if(R==0)
            return res;

        int[][] dic={{0,1},{1,0},{0,-1},{-1,0}};
        int[][] flag=new int[L][R];

        int N=L*R;
        int i=0;
        int x=0;
        int y=0;
        while(res.size()<N)
        {
            res.add(matrix[x][y]);
            flag[x][y]=1;
            if(x+dic[i][0]>=L||x+dic[i][0]<0||y+dic[i][1]>=R||y+dic[i][1]<0||flag[x+dic[i][0]][y+dic[i][1]]==1)
            {
                i++;
                if(i==4)
                    i=0;
            }
            x+=dic[i][0];
            y+=dic[i][1];
        }
        return res;
    }
}
