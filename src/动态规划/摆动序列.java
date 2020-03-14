package 动态规划;

import java.util.LinkedList;

public class 摆动序列 {
    public int wiggleMaxLength(int[] nums) {

        if(nums.length<=1){
            return nums.length;
        }

        int temp=nums[0];
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==temp){
                continue;
            }else {
                index=i;
                break;
            }
        }
        if(index==0){
            return 1;
        }
        int res=2;
        boolean flag=nums[index]>nums[0];
        for(int i=index;i<nums.length;i++){
            if(nums[i]==temp){
                continue;
            }
            if(flag){
                if(nums[i]>temp){
                    temp=nums[i];
                }else{
                    flag=false;
                    res++;
                    temp=nums[i];
                }
            }else{
                if(nums[i]<temp){
                    temp=nums[i];
                }else{
                    flag=true;
                    res++;
                    temp=nums[i];
                }
            }
        }

        return res;
    }
}
