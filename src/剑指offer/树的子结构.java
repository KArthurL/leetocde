package 剑指offer;

public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null||root1==null)
            return false;
        boolean res=false;

        if(root1.val==root2.val)
            res=match(root1.left,root2.left)&&match(root1.right,root2.right);

        if(res)
            return true;
        else
            return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }

    private boolean match(TreeNode root1,TreeNode root2)
    {
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val==root2.val)
            return match(root1.left,root2.left)&&match(root1.right,root2.right);
        else
            return false;

    }
}
