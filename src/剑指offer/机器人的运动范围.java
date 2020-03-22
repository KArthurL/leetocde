package 剑指offer;

public class 机器人的运动范围 {
    static int res=0;
    public static int movingCount(int m, int n, int k) {
        boolean[][] flags=new boolean[m][n];
        help(0,0,k,flags);
        return res;
    }
    private static void help(int i,int j,int k,boolean[][] flags){
        if(i<0||i>=flags.length||j<0||j>=flags[0].length||flags[i][j]||sum(i,j)>k){
            return;
        }
        res++;
        flags[i][j]=true;
        help(i+1,j,k,flags);
        help(i,j+1,k,flags);
        help(i-1,j,k,flags);
        help(i,j-1,k,flags);
    }

    private static int sum(int i,int j){
        return sum(i)+sum(j);
    }
    private static int sum(int x){
        int sum=0;
        while(x!=0){
            sum+=x%10;
            x=x/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(3,2,17));
    }
}
