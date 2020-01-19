import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 任务调度器 {

    public static void main(String[] args) {
        char[] tasks={'A','B','A','A','B','B'};
        System.out.println(leastInterval(tasks,2));
    }

    public static int leastInterval(char[] tasks, int n) {

        int res=0;
        int[] dic=new int[26];
        for(char c:tasks){
            dic[c-'A']++;
        }
        PriorityQueue<Character> queue=new PriorityQueue<>(((o1, o2) -> dic[o2-'A']-dic[o1-'A']));
        for(char c:tasks){
            if(!queue.contains(c)) {
                queue.offer(c);
            }
        }
        while(!queue.isEmpty()){
            int i=0;
            List<Character> temp=new ArrayList<>();
            while(i<=n){
                if(!queue.isEmpty()){
                    char c=queue.poll();
                    dic[c-'A']--;
                    if(dic[c-'A']!=0) {
                        temp.add(c);
                    }
                }
                i++;
                res++;
                if(queue.isEmpty()&&temp.size()==0) {
                    break;
                }
            }
            for(char c:temp){
                    queue.offer(c);
            }
        }

        return res;
    }
}
