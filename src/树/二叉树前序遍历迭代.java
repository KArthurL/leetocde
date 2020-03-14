package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树前序遍历迭代 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res=new ArrayList<>();
        LinkedList<TreeNode> stack=new LinkedList<>();
        if(root==null)
            return res;

        stack.push(root);
        while(stack.size()>0){
            TreeNode temp=stack.pop();
            res.add(temp.val);
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }

        }




        return res;

    }
}
