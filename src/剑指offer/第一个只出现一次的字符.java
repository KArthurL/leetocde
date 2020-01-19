package 剑指offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 第一个只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {
        LinkedList<Integer> queue=new LinkedList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){

            char c=str.charAt(i);
            if(!map.containsKey(c)){
                queue.offer(i);
                map.put(c,i);
            }else{
                if(queue.contains(map.get(c))){
                    queue.remove(map.get(c));
                }
            }


        }
        return queue.size()==0?-1:queue.poll();
    }



}
