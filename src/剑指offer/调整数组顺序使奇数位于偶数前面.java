package 剑指offer;

public class 调整数组顺序使奇数位于偶数前面 {

    public void reOrderArray(int [] nums) {
        int p=0;
        int q=nums.length-1;
        while(p<q){
            while(p<q&&(nums[q]&1)==0){
                q--;
            }
            while(p<q&&(nums[p]&1)==1){
                p++;
            }
            int temp=nums[p];
            nums[p]=nums[q];
            nums[q]=temp;
        }



    }

}
