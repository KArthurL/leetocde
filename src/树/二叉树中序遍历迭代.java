package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中序遍历迭代 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode cur=root;
        while(cur!=null||stack.size()>0){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }
}
