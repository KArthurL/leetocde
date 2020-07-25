package 笔试.网易;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        num2();
    }
    public static void num1(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int[] nums=new int[n-1];
        int pre=-1;
        for(int i=0;i<n;i++){
            int x=scanner.nextInt();
            if(pre<0){
                pre=x;
            }else{
                nums[i-1]=x-pre;
                if(nums[i-1]<=0){
                    System.out.println(-1);
                    return;
                }
                pre=x;
            }
        }
        if(n==2){
            System.out.println(nums[0]);
            return;
        }
        int count=gcd(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            count=gcd(gcd(nums[i-1],nums[i]),count);
            if(count==1){
                System.out.println(1);
                return;
            }
        }
        System.out.println(count);
    }
    private  static int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    public static void num2(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int D=scanner.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i]=scanner.nextInt();
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(a[o1]==a[o2]){
                    return b[o1]-b[o2];
                }else{
                    return a[o1]-a[o2];
                }
            }
        });
        for(int i=0;i<n;i++){
            queue.offer(i);
        }
        Deque<Integer> deque=new LinkedList<>();
        while(!queue.isEmpty()){
            deque.addLast(queue.poll());
        }
        int hp=0;
        while(!deque.isEmpty()){
            int index=deque.peekFirst();
            if(D==a[index]){
                index=deque.peekLast();
                if(D==a[index]){
                    index=deque.pollFirst();
                    hp+=b[index];
                }else{
                    index=deque.pollLast();
                    hp+=b[index];
                }

            }else if (D<a[index]){
                hp+=b[index];
                deque.pollFirst();
            }else{
                deque.pollFirst();
            }
            D++;
        }
        System.out.println(hp);
    }
    public static void num3() {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int start=scanner.nextInt();
        boolean[] flag=new boolean[m];
        flag[start]=true;

        for(int i=0;i<n;i++){
            boolean v=false;
            int num=scanner.nextInt();
            int[] temp=new int[num];
            for(int j=0;j<num;j++){
                temp[j]=scanner.nextInt();
                if(flag[temp[j]]){
                    v=true;
                }
            }
            if(v) {
                for (int x : temp){
                    flag[x]=true;
                }
            }
        }
        int count=0;
        for(boolean f:flag){
            if(f){
                count++;
            }
        }
        System.out.println(count);

    }
    public static void num4(){
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] nums=new int[n][m];
        int[][] dp=new int[n][m];
        scanner.nextLine();
        for(int i=0;i<n;i++){
            int x=0;
            for(char c:scanner.nextLine().toCharArray()){
                if(c=='1'){
                    nums[i][x]=1;
                    dp[i][x++]=10000;
                }else{
                    nums[i][x++]=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            if(nums[i][0]==1) {
                dp[i][0] = dp[i-1][0]+1;
            }
        }
        for(int i=1;i<m;i++){
            if(nums[0][i]==1) {
                dp[0][i] = dp[0][i-1]+1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(nums[i][j]==1){
                    int temp=Math.min(dp[i-1][j],dp[i][j-1])+1;
                    dp[i][j]=Math.min(temp,dp[i][j]);
                }
            }
        }
        for(int i=n-2;i>=0;i--){
            if(nums[i][m-1]==1) {
                dp[i][m-1] = dp[i+1][m-1]+1;
            }
        }
        for(int i=m-2;i>=0;i--){
            if(nums[n-1][i]==1) {
                dp[n-1][i] = dp[n-1][i+1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                if(nums[i][j]==1){
                    int temp=Math.min(dp[i+1][j],dp[i][j+1])+1;
                    dp[i][j]=Math.min(temp,dp[i][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dp[i][j]);
                if(j==m-1){
                    System.out.println();
                }else{
                    System.out.print(" ");
                }
            }
        }
    }
}

