package 笔试.baidu;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        num3();
    }
    public static void num1(){
        Scanner scanner=new Scanner(System.in);
        long n=scanner.nextLong();
        System.out.println(n*(n-1)-1);
        String s="sf";

    }

    public static void num2(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long[] nums=new long[n];
        for(int i=0;i<n;i++){
            nums[i]=scanner.nextLong();
        }
        Arrays.sort(nums);
        long res=0;
        while(nums[n-1]>=n){
            long temp=nums[n-1];
            long temp2=nums[n-2];
            long base=Math.min((temp-n)/n+1,(temp-temp2)/(n-1));
            res+=base;
            nums[n-1]-=n*base;
            for(int i=0;i<n-1;i++){
                nums[i]+=base;
            }
            Arrays.sort(nums);
        }
        System.out.println(res);
    }
    public static int third;
    public static void num3(){
        third=1;
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] weight=new int[n];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            weight[i]=scanner.nextInt();
        }

        for(int i=0;i<n-1;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            if(map.containsKey(x)){
                map.get(x).add(y);
            }else{
                List<Integer> tem=new ArrayList<>();
                tem.add(y);
                map.put(x,tem);
            }
            if(map.containsKey(y)){
                map.get(y).add(x);
            }else{
                List<Integer> tem=new ArrayList<>();
                tem.add(x);
                map.put(y,tem);
            }
        }
        boolean[] flags=new boolean[n];
        for(int i=1;i<=n;i++){
            dfs(i,0,map,flags,weight,1);
        }
        System.out.println(third);
    }
    private static void dfs(int index,int res,Map<Integer,List<Integer>> map,boolean[] flags,int[] weight,int w){

        if(weight[index-1]<=w||flags[index-1]){
            third=Math.max(res,third);

        }else{
            List<Integer> list=map.get(index);
            flags[index-1]=true;
            for(int i:list){

                dfs(i,res+1,map,flags,weight,weight[index-1]);
            }
            flags[index-1]=false;

        }
    }
}
