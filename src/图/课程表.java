package 图;

import java.util.*;

public class 课程表 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] course=new int[numCourses];
        LinkedList<Integer> queue=new LinkedList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] p:prerequisites){
            course[p[0]]++;
            if(!map.containsKey(p[1])){
                List<Integer> temp=new ArrayList<>();
                temp.add(p[0]);
                map.put(p[1],temp);
            }else{
                map.get(p[1]).add(p[0]);
            }

        }
        for(int i=0;i<numCourses;i++){
            if(course[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int x=queue.poll();
            List<Integer> list=map.get(x);
            if(list!=null){
                for(int i:list){
                    course[i]--;
                    if(course[i]==0){
                        queue.offer(i);
                    }
                }
            }
        }
        for(int i:course){
            if(i>0)
                return false;
        }
        return true;
    }
}
