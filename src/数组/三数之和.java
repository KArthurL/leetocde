package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int start;
        int end;
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            if(list.contains(nums[i]))
                continue;
            else
                list.add(nums[i]);
            start=i+1;
            end=nums.length-1;
            while(start<end)
            {
                if(nums[i]+nums[start]+nums[end]==0)
                {
                    int tem=nums[start];
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    ans.add(temp);
                    while(nums[start]==tem&&start!=end)
                        start++;
                }
                else if(nums[i]+nums[start]+nums[end]>0)
                    end--;
                else
                    start++;
            }
        }
        return ans;
    }
}
