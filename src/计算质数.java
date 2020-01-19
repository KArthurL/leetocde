public class 计算质数 {
    public int countPrimes(int n) {
        int sum=0;
        int[] a=new int[n];
        if(n<=2)
            return 0;
        a[1]=1;
        for(int i=2;i<=(int)Math.pow(n,0.5);i++)
        {
            if (a[i]==0)
            {
                for(int j=i+i;j<n;j=j+i)
                    a[j]=1;
            }
        }
        for(int x:a)
        {
            if(x==0)
                sum++;
        }
        return sum-1;

    }
}
