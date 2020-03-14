package 数组;

import java.util.Arrays;

public class 最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res=nums[0]+nums[1]+nums[2];




        return res;
    }
}
