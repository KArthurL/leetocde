import java.util.HashMap;
import java.util.Map;

public class 打家劫舍TREE {

    public Map<TreeNode,Integer> map=new HashMap<>();


    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        int m=root.val;
        if(map.containsKey(root)){
            m=map.get(root);
        }else{
            if(root.left!=null){
                m+=rob(root.left.left)+rob(root.left.right);
            }
            if(root.right!=null){
                m+=rob(root.right.left)+rob(root.right.right);
            }
            m=Math.max(m,rob(root.left)+rob(root.right));
            map.put(root,m);
        }


        return m;
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


