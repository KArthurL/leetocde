package 数组;

public class 搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        if(nums.length==1)
            return nums[0]==target?0:-1;
        if(nums[0]<nums[nums.length-1])
            return help(nums,0,nums.length-1,target);
        int index=find(nums);
        if(nums[0]==target)
            return 0;
        else
            return nums[0]>target?help(nums,index,nums.length-1,target):help(nums,0,index-1,target);
    }
    public int find(int[] nums){
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=(start+end)/2;
            if(nums[mid]>nums[mid+1]){
                return mid+1;
            }else if(nums[mid]>nums[0]){
                start=mid+1;
            }else if(nums[mid]<nums[0]){
                end=mid;
            }
        }
        return 0;
    }

    public int help(int[] nums,int start,int end,int target)
    {
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
