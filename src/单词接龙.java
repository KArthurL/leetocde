import java.util.*;

public class 单词接龙 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)){
            return 0;
        }
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:wordList){
            char[] cs=s.toCharArray();
            for(int i=0;i<s.length();i++){
                char temp=cs[i];
                cs[i]='*';
                String x=new String(cs);
                if(map.containsKey(x)){
                    map.get(x).add(s);
                }else{
                    List<String> list=new ArrayList<>();
                    list.add(s);
                    map.put(x,list);
                }
                cs[i]=temp;
            }
        }
        LinkedList<String> queue=new LinkedList<>();
        LinkedList<String> requeue=new LinkedList<>();
        Set<String> set1=new HashSet<>();
        Set<String> set2=new HashSet<>();
        queue.offer(beginWord);
        requeue.offer(endWord);
        int res=1;
        int rev=1;
        while(!queue.isEmpty()&&!requeue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                String s=queue.poll();

                char[] cs=s.toCharArray();
                for(int j=0;j<s.length();j++){
                    char temp=cs[j];
                    cs[j]='*';
                    String x=new String(cs);
                    if(map.containsKey(x)){
                        List<String> m=map.get(x);
                        for(String ss:m){

                            if(!set1.contains(ss)){
                                if(set2.contains(ss)){
                                    return res+rev;
                                }else {
                                    queue.offer(ss);
                                    set1.add(ss);
                                }
                            }
                        }

                    }
                    cs[j]=temp;
                }

            }
            res++;
            if(queue.contains(endWord)){
                return res;
            }
            n=requeue.size();
            for(int i=0;i<n;i++){
                String s=requeue.poll();
                char[] cs=s.toCharArray();
                for(int j=0;j<s.length();j++){
                    char temp=cs[j];
                    cs[j]='*';
                    String x=new String(cs);
                    if(map.containsKey(x)){
                        List<String> m=map.get(x);
                        for(String ss:m){
                            if(!set2.contains(ss)){
                                if(set1.contains(ss)){
                                    return res+rev;
                                }
                                requeue.offer(ss);
                                set2.add(ss);
                            }
                        }

                    }
                    cs[j]=temp;
                }

            }
            rev++;
        }
        return 0;

    }
    private static boolean check(String s1,String s2 ){
        if(s1.length()!=s2.length()){
            return  false;
        }
        int res=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                res++;
                if(res>1){
                    return false;
                }
            }
        }
            return res==1;
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(ladderLength("hit","cog",list));
    }
}
