import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 最小高度树 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList<Integer> queue=new LinkedList<>();
        int[] indegree=new int[n];
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        if(n==1)
        {
            List<Integer> res=new ArrayList<>();
            res.add(0);
            return res;
        }
        for(int[] e:edges)
        {
            indegree[e[0]]++;
            indegree[e[1]]++;
            if(map.containsKey(e[0]))
                map.get(e[0]).add(e[1]);
            else
            {
                List<Integer> temp=new ArrayList<>();
                temp.add(e[1]);
                map.put(e[0],temp);
            }
            if(map.containsKey(e[1]))
                map.get(e[1]).add(e[0]);
            else
            {
                List<Integer> temp=new ArrayList<>();
                temp.add(e[0]);
                map.put(e[1],temp);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==1)
            {
                queue.offer(i);
            }

        }
        while(!queue.isEmpty())
        {
            List<Integer> res=new ArrayList<>();
            while(!queue.isEmpty())
            {
                res.add(queue.poll());
            }
            for(Integer x:res)
            {
                List<Integer> tem=map.get(x);
                for(Integer y:tem)
                {
                    indegree[y]--;
                    if(indegree[y]==1)
                        queue.offer(y);
                }

            }
            if(queue.isEmpty())
                return res;

        }
        return null;
    }
}
