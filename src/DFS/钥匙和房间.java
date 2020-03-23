package DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 钥匙和房间 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit=new boolean[rooms.size()];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int x=queue.poll();
            if(!visit[x]) {
                visit[x]=true;
                List<Integer> list = rooms.get(x);
                for(int num:list){
                    queue.offer(num);
                }
            }
        }
        for(boolean f:visit){
            if(!f){
                return false;
            }
        }
        return true;
    }
}
