package 笔试.华为;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        num1();
    }

    public static void num1(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            help1(s);
        }

    }
    public static void help1(String s){
        if(s==null){
            System.out.println(0);
        }
        String[] ss=s.split(" ");
        int m=0;
        for(int i=0;i<ss.length;i++){
            if(ss[i].equals("NOT")){
                m=(m==0)?1:0;
                int index=i+1;
                if(index==ss.length||!help11(ss[index])){
                    System.out.println(0);
                    return;
                }
                continue;
            }
            if((i&1)==m){
                boolean flag=help11(ss[i]);
                if(!flag){
                    System.out.println(0);
                    return;
                }
            }else{
                if(!ss[i].equals("OR")&&!ss[i].equals("AND")){
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
    }
    public static boolean help11(String s){
        for(char c:s.toCharArray()){
            if(c>'z'||c<'a'){
                return false;
            }
        }
        return true;
    }

    public static void num2(){
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String,Integer> map=new HashMap<>();
        PriorityQueue<String> queue=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            String s=scanner.nextLine();
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String s:map.keySet()){
            queue.offer(s);
        }
        while (!queue.isEmpty()){
            String s=queue.poll();
            System.out.println(s+" "+map.get(s));
        }

    }
    static boolean flag=false;
    public static void num3(){
        flag=false;
        Scanner scanner=new Scanner(System.in);
        String start=null;
        Map<String, List<String>> map=new HashMap<>();
        Set<String> set=new HashSet<>();
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            if(s.startsWith("search")){
                String[] ss=s.split(":");
                start=ss[1];
                break;
            }else{
                String[] ss=s.split(":");
                if(map.containsKey(ss[0])){
                    map.get(ss[0]).add(ss[1]);
                }else{
                    List<String> temp=new ArrayList<>();
                    temp.add(ss[1]);
                    map.put(ss[0],temp);
                }
            }
        }
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();

        dfs(start,set,map,res,temp);
        if(flag){
            System.out.println("Bad coding -- loop include as bellow:" );
            for(List<String> list:res){
                for(String s:list){
                    System.out.print(s+" ");
                }
                System.out.println();
            }
        }else{
            System.out.println("none loop include "+start);
        }


    }
    public static void dfs(String start,Set<String> set,Map<String, List<String>> map,List<List<String>> res,List<String> temp){
        if(set.contains(start)){
            flag=true;
            List<String> list=new ArrayList<>();
            int index=0;
            for(int i=0;i<temp.size();i++){
                if(temp.get(i).equals(start)){
                    index=i;
                    break;
                }
            }
            for(int i=index;i<temp.size();i++){
                list.add(temp.get(i));
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        if(!map.containsKey(start)){
            return;
        }
        set.add(start);
        temp.add(start);
        List<String> list=map.get(start);
        for(String s:list){

            dfs(s,set,map,res,temp);

        }
        temp.remove(start);
        set.remove(start);

    }
}
