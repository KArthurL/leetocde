public class 打家劫舍2 {

    public int rob(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];
        dp1[1]=nums[0];
        dp2[1]=nums[1];
        for(int i=2;i<nums.length;i++){

            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+nums[i-1]);

        }
        for(int i=2;i<nums.length;i++){

            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[i]);

        }


        return Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);
    }


}
