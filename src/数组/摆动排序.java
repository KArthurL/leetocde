package 数组;

public class 摆动排序 {
    public void wiggleSort(int[] nums) {

        int n=nums.length;
        int mid=0;



    }

/*    private int help(int[] nums,int left,int right,int rank){
        int k=nums[left];
        while(left<right){
            while(left<right&&nums[right]>=k){
                right--;
            }
            nums[left]=nums[right];
            while(left<right&&nums[left]<=k){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=k;
        if(left-1==rank){
            return k;
        }else if(left-1<rank){
            return help(nums,left+1,right,rank);
        }
    }*/
}
