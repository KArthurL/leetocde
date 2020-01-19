package 排序算法;

public class 希尔 {



    public static void shellSort(int[] nums){


        int length=nums.length;
        int gap=length/2;
        while(gap>0){

            for(int i=gap;i<length;i++){
                int val=nums[i];
                int j=i;
                while(j-gap>=0&&nums[j-gap]>val){
                    nums[j]=nums[j-gap];
                    j-=gap;
                }
                nums[j]=val;
            }


            gap/=2;
        }


    }
}
