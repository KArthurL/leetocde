package 剑指offer;

public class 平衡二叉树 {

    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        helper(root);
        return flag;
    }

    public int helper(TreeNode rot){
        if(rot==null){
            return 0;
        }
        int left = helper(rot.left);
        int right = helper(rot.right);
        if(Math.abs(left-right)>1){
            flag = false;
        }
        return Math.max(left,right)+1;
    }


}
