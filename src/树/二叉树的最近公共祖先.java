package 树;

public class 二叉树的最近公共祖先 {

    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        help(root,p,q);

        return res;
    }

    private boolean help(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }

        int right=help(root.right,p,q)?1:0;
        int left=help(root.left,p,q)?1:0;
        int mid=(root==p||root==q)?1:0;
        if(right+left+mid>=2){
            res=root;
        }
        return right+left+mid>0;
    }
}
