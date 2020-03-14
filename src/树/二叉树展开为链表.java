package 树;

public class 二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        flatten(left);
        flatten(right);
        root.right=left;
        while(root.right!=null)
            root=root.right;
        root.right=right;

    }


}
