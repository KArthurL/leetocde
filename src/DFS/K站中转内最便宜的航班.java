package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class K站中转内最便宜的航班 {
    public static final int M =100000001;
    public static int res=Integer.MAX_VALUE;
    public static int[][] weight;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            weight=new int[n][n];
        Map<Integer, List<Integer>> map=new HashMap<>();
        boolean[] visit=new boolean[n];
        for(int i=0;i<flights.length;i++){
            int x=flights[i][0];
            int y=flights[i][1];
            int z=flights[i][2];
            weight[x][y]=z;
            if(map.containsKey(x)){
                map.get(x).add(y);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(y);
                map.put(x,list);
            }
        }
        dfs(map,visit,src,dst,K+1,0);
        return res;

    }
    public void dfs(Map<Integer, List<Integer>> map,boolean[] visit,int src,int dst,int k,int cost){

        if(src==dst){
            res=Math.min(res,cost);
            return;
        }
        if(cost>res||k==0||visit[src]){
            return;
        }
        List<Integer> list=map.get(src);
        if(list==null){
            return;
        }
        visit[src]=true;
        for(int s:list){
            dfs(map,visit,s,dst,k-1,cost+weight[src][s]);
        }
        visit[src]=false;
    }
}
