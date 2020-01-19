package 剑指offer;

public class 逆序对 {

    private int n=0;
    public int InversePairs(int [] array) {

        sort(array,0,array.length-1);
        return n%1000000007;
    }
    public void merge(int[] a,int left,int mid,int right)
    {
        int[] temp=new int[right-left+1];
        int p1=mid;
        int p2=right;
        for(int i=temp.length-1;i>=0;i--)
        {
            if(p1>=left&&p2>=mid+1)
            {
                if(a[p1]>a[p2])
                {
                    temp[i]=a[p1--];
                    n+=p2-mid;
                    if(n>1000000007)
                        n=n%1000000007;
                }
                else{
                    temp[i]=a[p2--];
                }
            }
            else if(p1>=left)
            {
                temp[i]=a[p1--];
            }
            else
            {
                temp[i]=a[p2--];
            }
        }
        for(int i=left;i<=right;i++)
        {
            a[i]=temp[i-left];
        }

    }
    public void sort(int[] a,int left,int right)
    {
        int mid=(left+right)/2;
        if(left<right)
        {
            sort(a,left,mid);
            sort(a,mid+1,right);
            merge(a,left,mid,right);
        }
    }
}
