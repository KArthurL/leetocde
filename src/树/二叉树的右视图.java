package 树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {

       /* LinkedList<TreeNode> queue=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {

                TreeNode temp=queue.poll();
                if(i==size-1)
                    res.add(temp.val);
                if(temp.left!=null)
                queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);

            }

        }
        return res;*/
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        help(0,map,root);
        for(int i=0;i<map.size();i++)
            res.add(map.get(i));
        return res;
    }
    private void help(int depth, Map<Integer,Integer> map, TreeNode root)
    {
        if(root==null)
            return;
        if(!map.containsKey(depth))
        {
            map.put(depth,root.val) ;
        }
        help(depth+1,map,root.right);
        help(depth+1,map,root.left);

    }
}
