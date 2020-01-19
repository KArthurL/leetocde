public class 把二叉搜索树转换为累加树 {


    int res=0;
    public TreeNode convertBST(TreeNode root) {

        help(root);
        return root;

    }
    public void help(TreeNode root){
        if(root==null)
        {
            return ;
        }
        help(root.right);
        int v=root.val;
        root.val+=res;
        res+=v;
        help(root.left);

    }
}
