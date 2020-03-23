package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大整除子集 {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        if(nums==null||nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<Integer>[] list=new List[nums.length];
        for(int i=0;i<nums.length;i++){
            List<Integer> temp;
            int sum=0;
            int index=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0) {
                    List<Integer> l = list[j];
                    if(l.size()>sum){
                        sum=l.size();
                        index=j;
                    }
                }
            }
            temp=index==i?new ArrayList<>():new ArrayList<>(list[index]);
            temp.add(nums[i]);
            list[i]=temp;
        }
        int sum=0;
        int x=0;
        for(int i=0;i<list.length;i++){
            if(list[i].size()>sum){
                sum=list[i].size();
                x=i;
            }
        }
        return list[x];


    }
}
