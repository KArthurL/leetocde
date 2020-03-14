import java.util.*;

public class Main {


    public static void main(String[] args) {

      Scanner in=new Scanner(System.in);
        int n=Integer.valueOf(in.nextLine());
        String x1=in.nextLine();
        String x2=in.nextLine();
        if(x1.charAt(0)=='X'){
            System.out.println(-1);
        }else {
            help(n, x1, x2);
        }
    }
    private static void help(int n,String x1,String x2){
        int[][] dp=new int[2][n];
        dp[0][0]=1;
        for(int i=1;i<n;i++){
            char c1=x1.charAt(i);
            char c2=x2.charAt(i);
            dp[0][i]=c1=='.'?dp[0][i-1]+dp[1][i-1]:0;
            dp[1][i]=c2=='.'?dp[0][i-1]+dp[1][i-1]:0;
        }
        System.out.println(dp[1][n-1]==0?-1:dp[1][n-1]);
    }

    public static void num2(){
        Scanner in=new Scanner(System.in);

        int n=in.nextInt();
        int x=in.nextInt();
        int[] nums=new int[n];
        int[] nums2=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
            nums2[i]=nums[i];
        }

        HashMap<Integer,Integer>  map=new HashMap<>();

       for(int num:nums){
           map.put(num,map.getOrDefault(num,0)+1);
           if((num|x)!=num) {
               map.put(num|x,map.getOrDefault(num|x,0)+1 );
           }
       }
       int res=0;
       for(Integer key:map.keySet()){
           res=Math.max(res,map.get(key));
       }
        System.out.println(res);
    }

    public void num3(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int L=in.nextInt();
        int R=in.nextInt();

        if(k==1){
            double res=Math.pow(R-L+1,n);
            System.out.println((int)(res%1000000007));
        }else{

        }
    }
    public static void num4(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int k=in.nextInt();
        Map<Integer, List<Integer>> map=new HashMap<>();
        int[] nums=new int[n];
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        for(int i=0;i<m;i++){
            int x=in.nextInt();
            int y=in.nextInt();
           if(map.containsKey(x)){
               map.get(x).add(y);
           }else{
               List<Integer> temp=new ArrayList<>();
               temp.add(y);
               map.put(x,temp);
           }
           if(map.containsKey(y)){
               map.get(y).add(x);
           }else{
               List<Integer> temp=new ArrayList<>();
               temp.add(x);
               map.put(y,temp);
           }
        }
        for(int i=0;i<n;i++){

            int sum=0;
            int[] temp=new int[k];
            temp[nums[i]-1]=1;
            List<Integer> list=map.get(i+1);
            for(int x:list){
                int one=nums[x-1];
                temp[one-1]=1;
            }
            for(int j=0;j<k;j++){
                int t= temp[j];
                sum+=t==0?helpx(map,j+1,new boolean[n],i+1,nums):1;
            }
            res[i]=sum;
        }
        for(int r:res){
            System.out.print(r-1+" ");
        }
    }
    private static int  helpx(Map<Integer,List<Integer>> map,int k,boolean[] flags,int start,int[] locations){

        List<Integer> list=map.get(start);
        for(int s:list){
            if(locations[s-1]==k){
                return 1;
            }
        }
        int n=Integer.MAX_VALUE;
        for(int s:list){
            if(!flags[s-1]){
                flags[s-1]=true;
                int tem=helpx(map,k,flags,s,locations);
                if(tem>0){
                    n=Math.min(n,tem);
                }
            }
        }
        return n==Integer.MAX_VALUE?-1:n+1;

    }

}
