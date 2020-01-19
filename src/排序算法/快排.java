package 排序算法;

public class 快排 {


    public static void main(String[] args) {
        int [] nums={5,2,3,1};
        quickSort(nums);
        for(int n:nums){
            System.out.println(n);
        }
    }

    public static void quickSort(int[] data){

        help(data,0,data.length-1);

    }


    public static void help(int[] data,int left,int right){

        int pivot=0;
        if(left<right){
            pivot=partition(data,left,right);
            help(data,left,pivot-1);
            help(data,pivot+1,right);
        }

    }

    public static int partition(int[] data,int left,int right){

        int k=data[left];
        while(left<right){
            while(left<right&&data[right]>=k){
                right--;
            }
            data[left]=data[right];
            while(left<right&&data[left]<=k){
                left++;
            }
            data[right]=data[left];
        }
        data[left]=k;
        return left;
    }
}
