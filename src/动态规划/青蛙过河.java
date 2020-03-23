package 动态规划;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 青蛙过河 {

    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],new HashSet<>());
        }
        map.get(0).add(0);
        for(int i=0;i<stones.length;i++){
            for(int k:map.get(stones[i])){
                for(int s=k-1;s<=k+1;s++){
                    if(s>0&&map.containsKey(stones[i]+s)){
                        map.get(stones[i]+s).add(s);
                    }
                }
            }
        }
        return map.get(stones[stones.length-1]).size()>0;
    }
}
