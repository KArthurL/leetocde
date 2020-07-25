package 笔试.招商银行;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        num2();

    }

    public static void num2(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            int nums=scanner.nextInt();
            int[][] a=new int[nums][2];

            for(int j=0;j<nums;j++){
                a[j][0]=scanner.nextInt();
            }
            for(int j=0;j<nums;j++){
                a[j][1]=scanner.nextInt();
            }
            help2(nums,a);
        }
    }
    public static void help2(int n,int[][] a){
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });
        int[] dp=new int[n];
        int cur=0;
        int ans=0;
        for(int i=0;i<n;i++){
            cur=0;
            boolean flag=true;
            for(int j=0;j<i;j++){

                if(a[j][1]>a[i][1]){
                    cur=Math.max(cur,dp[j]);
                }
            }
            dp[i]=cur+1;
            ans=Math.max(ans,dp[i]);

        }
        System.out.println(ans);
    }



    public static void num1(){

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            int nums=scanner.nextInt();
            int[] temp=new int[nums];
            for(int j=0;j<nums;j++){
                temp[j]=scanner.nextInt();
            }
            help1(nums,temp);
        }



    }
    public static void help1(int n,int[] nums){
        boolean flag=true;
        int count=0;
        for(int num:nums){
            if(num>1){
                flag=false;
            }
            if(num>0){
                count++;
            }
        }
        if(flag){
            System.out.println(-1);
        }else{
            System.out.println(count+1);
        }
    }
}
