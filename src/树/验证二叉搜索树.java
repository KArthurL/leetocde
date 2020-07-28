package 树;

public class 验证二叉搜索树 {

    TreeNode cur;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        boolean flag=isValidBST(root.left);
        if(!flag)
            return false;
        if (cur!=null)
        {
            flag=flag&&root.val>cur.val;
        }
        cur=root;
        flag=flag&&isValidBST(root.right);
        return flag;
    }
}
