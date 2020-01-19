package 数组;

import java.util.Arrays;

public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        boolean flag=false;
        int index=nums.length-1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                flag=true;
                while(nums[i]>=nums[index]) {
                    index--;
                }
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                Arrays.sort(nums,i+1,nums.length);
                break;
            }


        }
        if(!flag)
            Arrays.sort(nums);
    }
}
