package 数组;

public class 最大交换 {

    public int maximumSwap(int num) {

        char[] c=String.valueOf(num).toCharArray();
        int[] n=new int[c.length];
        int[] maxs=new int[c.length];
        int[] indexs=new int[c.length];
        int max=0;
        int index=c.length-1;
        for(int i=c.length-1;i>=0;i--){
            n[i]=c[i]-'0';
            if(n[i]>max){
                max=n[i];
                index=i;
            }
            maxs[i]=max;
            indexs[i]=index;
        }
        for(int i=0;i<c.length;i++){
            if(n[i]>=n[indexs[i]]){
                continue;
            }else{
                int temp=n[i];
                n[i]=maxs[i];
                n[indexs[i]]=temp;
                break;
            }
        }
        int res=0;
        for(int x:n){
           res=res*10+x;
        }
        return res;
    }
}
