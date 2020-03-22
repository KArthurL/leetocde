package baidu;

import java.util.*;

public class Main {

    static int num=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        List<String> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            int k=scanner.nextInt();
            Map<Integer, List<Integer>> map=new HashMap<>();
            for(int j=0;j<k-1;j++){
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

            res.add(help(n,map));
        }
        for(String s:res){
            System.out.println(s);
        }
    }
    public static String help(int n,Map<Integer, List<Integer>> map){
        boolean[] flags=new boolean[n];



        return null;
    }
    public static void dfs(Map<Integer, List<Integer>> map,boolean[] flags,int start,Set<Integer> set){
        List<Integer> list=map.get(start);



    }
}
