package 数组;

public class 递增的三元子序列 {
    public boolean increasingTriplet(int[] nums) {

        int max=Integer.MIN_VALUE;
        int res=0;
        for(int x:nums){
            if(x>max){
                max=x;
                res++;
                if(res>=3){
                    return true;
                }
            }
        }
        int min=Integer.MAX_VALUE;
        int res2=0;
        for(int i=nums.length-1;i>=0;i--){
            int x=nums[i];
            if(x<min){
                min=x;
                res2++;
                if(res>=3){
                    return true;
                }
            }
        }
        return res>=3||res2>=3;
    }
}
