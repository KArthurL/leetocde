package 数组;

public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {



        int i=matrix.length-1;
        int j=0;
        while(i>=0&&j<matrix[0].length){
            if(matrix[i][j]>target){
                i--;
                j=0;
            }else if(matrix[i][j]<target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
