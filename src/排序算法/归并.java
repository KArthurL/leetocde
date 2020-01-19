package 排序算法;

public class 归并 {


    public static void main(String[] args) {
        int [] nums={3,2,5,7,1,5,6,9,5};
        mergeSort(nums);
        for(int n:nums){
            System.out.println(n);
        }
    }

    public static void mergeSort(int[] data){
        mergeInternally(data,0,data.length-1);


    }

    private static void mergeInternally(int[] data,int start,int end){

        if(start>=end){
            return ;
        }

        int mid=(start+end)/2;
        mergeInternally(data,start,mid);
        mergeInternally(data,mid+1,end);
        merge(data,start,end,mid);


    }

    private static void merge(int data[],int start,int end,int mid){

        int [] temp=new int[end-start+1];


        int k=0;
        int i=start;
        int j=mid+1;
        while(i<=mid&&j<=end){
            if(data[i]<data[j]){
                temp[k++]=data[i++];
            }else
            {
                temp[k++]=data[j++];
            }

        }

        int p=i;
        int q=mid;
        if(j<=end){
            p=j;
            q=end;
        }
        while(p<=q){
            temp[k++]=data[p++];
        }

        if(end-start+1>0){
            System.arraycopy(temp,0,data,start,end-start+1);
        }


    }

}
