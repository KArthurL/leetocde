package 剑指offer;

public class 二叉搜索树与双向链表 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        return helpleft(pRootOfTree);
    }
    public TreeNode helpleft(TreeNode root)
    {
        if(root==null)
            return null;
        TreeNode left=helpright(root.left);
        TreeNode right=helpleft(root.right);
        root.left=left;
        if(left!=null)
            left.right=root;
        root.right=right;
        if(right!=null)
            right.left=root;
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;

    }
    public TreeNode helpright(TreeNode root)
    {
        if(root==null)
            return null;
        TreeNode left=helpright(root.left);
        TreeNode right=helpleft(root.right);
        root.left=left;
        if(left!=null)
            left.right=root;
        root.right=right;
        if(right!=null)
            right.left=root;
        while(root.right!=null)
        {
            root=root.right;
        }
        return root;
    }
}

