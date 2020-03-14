package 数组;

public class 颜色分类 {
    public void sortColors(int[] nums) {

        int left=0;
        int right=nums.length-1;
        int cur=0;
        while(cur<=right){
            if(nums[cur]==0){
                swap(nums,cur,left);
                cur++;
                left++;
            }else if(nums[cur]==2){
                swap(nums,cur,right);
                    right--;

            }else{
                cur++;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int tem=nums[i];
        nums[i]=nums[j];
        nums[j]=tem;
    }
}
