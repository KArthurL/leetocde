package 树;

public class 求根到叶子结点数字之和 {

    int res=0;
    public int sumNumbers(TreeNode root) {

        if(root==null){
            return res;
        }
        help(root,0);

        return res;
    }
    private void help(TreeNode root,int num){
        int x=num+root.val;
        if(root.left==null&&root.right==null){
            res+=x;
            return;
        }
        if(root.left!=null){
            help(root.left,x*10);
        }
        if(root.right!=null){
            help(root.right,x*10);
        }

    }

}
