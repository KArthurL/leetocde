import java.util.*;

public class 前k个高频元素 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2) -> map.get(o1)-map.get(o2));


        for(int n:map.keySet()){
            queue.add(n);
            if(queue.size()>k){
                queue.poll();
            }
        }
        for(int n:queue){
            res.add(n);

        }
        return res;




    }

}
