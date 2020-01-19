package 剑指offer;

public class 二叉搜索树的第k个结点 {

    int index=0;
    TreeNode res=null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {


        help(pRoot,k);
        return res;

    }
    private void help(TreeNode root,int k){

        if(root==null||res!=null){
            return ;
        }

        help(root.left,k);
        index++;
        if(index==k){
            res=root;
            return;
        }
        help(root.right,k);

    }


}
