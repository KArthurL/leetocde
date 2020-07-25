package 笔试.三六零;

import java.util.Scanner;

public class Main
{
    static int end=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        end = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        double res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                res += dfs(nums, i, 1);
                for (int j = i; j <= end; j++) {
                    nums[j]=0;
                }
            }
        }
        System.out.println(res);
    }
    private static double dfs(int[] nums,int index,int x){
        if(index>=nums.length){
            return 0;
        }
        double res=0;
        end=Math.max(index,end);
        if(nums[index]==1){
            res+=x;
            res+=dfs(nums,index+1,x+1);
        }else if(nums[index]==2){
            res+=0.5*dfs(nums,index+1,1)+0.5*(x+dfs(nums,index+1,x+1));
        }
        return res;
    }
}
