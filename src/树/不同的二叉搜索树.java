package 树;

public class 不同的二叉搜索树 {


    public int numTrees(int n) {

        if(n==0)
            return 0;
        int[] d=new int[n+1];
        d[0]=1;
        d[1]=1;
        for(int i=2;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {

                d[i]=d[i]+d[j]*d[i-j-1];
            }
        }
        return d[n];

    }
}
