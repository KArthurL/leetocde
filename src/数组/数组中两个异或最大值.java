package 数组;

import java.util.HashSet;
import java.util.Set;

public class 数组中两个异或最大值 {

    public int findMaximumXOR(int[] nums) {
        int res=0;
        int mask=0;

        for(int i=30;i>=0;i--){
            mask=mask|(1<<i);
            Set<Integer> set=new HashSet<>();
            for(int num:nums){
                set.add(num&mask);
            }
            int temp=res|(1<<i);
                for(int pre:set){
                    if(set.contains(pre^temp)){
                        res=temp;
                        break;
                    }
                }



        }




        return res;
    }
}
