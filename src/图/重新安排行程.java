package 图;

import java.util.*;

public class 重新安排行程 {
    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> res=new LinkedList<>();
        Map<String, Queue<String>> map=new HashMap<>();
        for(List<String> pair:tickets) {
            String key = pair.get(0);
            if (!map.containsKey(key)) {
                Queue<String> queue = new PriorityQueue<>();
                queue.offer(pair.get(1));
                map.put(key, queue);
            } else {
                map.get(key).offer(pair.get(1));
            }
        }

        visit(res,"JFK",map);
            return res;
    }
    private void visit(List<String> ans,String key,Map<String,Queue<String>> map){


        Queue<String> queue=map.get(key);
        while(queue!=null&&queue.size()>0){
            String next=queue.poll();
            visit(ans,next,map);
        }
        ans.add(0,key);
    }






}
