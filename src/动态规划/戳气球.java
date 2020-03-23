package 动态规划;

public class 戳气球 {




    public static int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        //左右+1方便操作。 nums[-1] = nums[n] = 1
        int[] newNums = new int[nums.length + 2];
        for (int i = 1; i < newNums.length - 1; i++) {
            newNums[i] = nums[i - 1];
        }
        newNums[0]=1;
        newNums[newNums.length-1]=1;

        for (int c = 0; c <nums.length ; c++) {
            for(int i=1;c+i<newNums.length-1;i++){
                for(int k=i;k<=i+c;k++){
                    dp[i][c+i]=Math.max(dp[i][c+i],dp[i][k-1]+dp[k+1][c+i]+newNums[i-1]*newNums[k]*newNums[i+c+1]);
                }
            }
        }

/*        for (int j = 2; j < newNums.length; j++) {
            //遍历所有的可能性，0-2...0-n,1-3...1-n,...
            for (int i = 0; i < newNums.length - j; i++) {
                for (int k = i + 1; k < i + j; k++) {
                    dp[i][i + j] = Math.max(dp[i][i + j], dp[i][k] + dp[k][i + j] + newNums[i] * newNums[k] * newNums[i + j]);
                }
            }
        }*/
        return dp[1][newNums.length-2];

    }

    public static void main(String[] args) {
       int[] nums={7,9,8,0,7,1,3,5,5,2,3};
        //int[] nums={3,1,5,8};
        System.out.println(maxCoins(nums));
    }

/*
    static int res=Integer.MIN_VALUE;
    public static int maxCoins(int[] nums) {


        boolean[] flag=new boolean[nums.length];

        help(nums,flag,nums.length,0);
        return res;

    }
    private static void help(int[] nums,boolean[] flag,int n,int temp){

        if(n==0){
            res=Math.max(temp,res);
        }else{

            for(int i=0;i<nums.length;i++){
                if(flag[i]){
                    continue;
                }else{
                    flag[i]=true;

                    int left=1;
                    int right=1;
                    int index=i-1;
                    while(index>=0){
                        if(flag[index]){
                            index--;
                        }else{
                            left=nums[index];
                            break;
                        }
                    }
                    index=i+1;
                    while(index<nums.length){
                        if(flag[index]){
                            index++;
                        }else{
                            right=nums[index];
                            break;
                        }
                    }
                    temp+=nums[i]*left*right;
                    help(nums,flag,n-1,temp);
                    temp-=nums[i]*left*right;
                    flag[i]=false;

                }
            }



        }

    }*/

}
