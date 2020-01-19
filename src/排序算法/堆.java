package 排序算法;

public class 堆 {



    public static void main(String[] args) {
        int [] nums={3,2,5,7,1,5,6,9,5};
        heapSort(nums);
        for(int n:nums){
            System.out.println(n);
        }
    }

   public static void heapSort(int[] nums){

       int length=nums.length;
        if(nums.length<=1){
            return;
        }
        heapBuild(nums);
        while(length>0){
            swap(nums,0,--length);
            heapfy(nums,length,0);
        }

   }

   private static void heapBuild(int[] nums){

       int length=nums.length;
       for(int i=(length-2)/2;i>=0;i--){
           heapfy(nums,length,i);
       }
   }

   private static void heapfy(int[] nums,int size,int i){

    while(true){
        int max=i;
        if((2*i+1)<size&&nums[max]<nums[2*i+1]){
            max=2*i+1;
        }
        if((2*i+2)<size&&nums[max]<nums[2*i+2]){
            max=2*i+2;
        }
        if(max==i){
            break;
        }
        swap(nums,i,max);
        i=max;


    }


   }

    private static  void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
