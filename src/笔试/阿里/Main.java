package 笔试.阿里;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        num1();

    }

    public static void num1(){
        long M=1000000007;
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long res=0;
        long[][] dp=new long[n+1][n+1];
        for(int i=1;i<n+1;i++){
            dp[i][0]=comb(i,0)%M;
            dp[i][1]=i;
            dp[0][i]=comb(i,0)%M;

        }
        for(int i=1;i<n+1;i++){
            dp[i][1]=i;
        }
        for(int i=2;i<=n;i++){
            for(int j=2;j<=i;j++){
                dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
            }
        }
        for(int i=1;i<=n;i++){
            res+=(dp[n][i]*i)%M;
        }



        System.out.println(res%M);
    }
    static Map<String,Long> map= new HashMap<>();
    private static long comb(int m,int n){
        if(m<n){
            return comb(n,m);
        }
        String key= m+","+n;
        if(n==0)
            return 1;
        if (n==1)
            return m;
        if(n>m/2)
            return comb(m,m-n);
        if(n>1){
            if(!map.containsKey(key)) {
                long num = comb(m - 1, n - 1) + comb(m - 1, n);
                map.put(key, num>1000000007?num%1000000007:num);
            }
            return map.get(key);
        }
        return -1;
    }

    static int res=Integer.MAX_VALUE;
    public static void num2(){
        Scanner scanner=new Scanner(System.in);
        String[] ss=scanner.nextLine().split(" ");
        res=Integer.MAX_VALUE;
        int n=Integer.valueOf(ss[0]);
        int m=Integer.valueOf(ss[1]);
        char[][] cs=new char[n][];
        for(int i=0;i<n;i++){
            cs[i]=scanner.nextLine().toCharArray();
        }
        int startx=0;
        int starty=0;
        boolean[][] flags=new boolean[n][m];
        Set<String> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(cs[i][j]=='E'){
                    int x=n+1-i;
                    int y=m+1-j;
                    if(x<n&&y<m){
                        set.add(x+","+y);
                    }
                }
                if(cs[i][j]=='S'){
                    startx=i;
                    starty=j;
                }
            }

        }
        dfs(startx,starty,cs,flags,0);
        System.out.println(res==Integer.MAX_VALUE?-1:res);

    }
    public static void dfs(int startx,int starty,char[][] cs,boolean[][] flags,int dis){
        if(startx<0||starty<0||startx>=cs.length||starty>=cs[0].length||flags[startx][starty]||cs[startx][starty]=='#'){
            return;
        }
        if(cs[startx][starty]=='E'){
            res=Math.min(res,dis);
            return;
        }
        flags[startx][starty]=true;
        dfs(startx+1,starty,cs,flags,dis+1);
        dfs(startx-1,starty,cs,flags,dis+1);
        dfs(startx,starty+1,cs,flags,dis+1);
        dfs(startx,starty-1,cs,flags,dis+1);
        dfs(cs.length-1-startx,cs[0].length-1-starty,cs,flags,dis+1);
        flags[startx][starty]=false;

    }
}
