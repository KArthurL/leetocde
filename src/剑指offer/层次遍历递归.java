package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 层次遍历递归 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res=new ArrayList<>();
        help(res,0,pRoot);
        return res;
    }
    private void help(ArrayList<ArrayList<Integer>> res,int index,TreeNode root){

        if(root==null){
            return;
        }
        if(res.size()==index){
            res.add(new ArrayList<>());
        }

            help(res,index+1,root.left);
        res.get(index).add(root.val);
        help(res,index+1,root.right);

    }
}
