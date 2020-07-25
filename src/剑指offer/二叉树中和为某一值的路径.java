package 剑指offer;

import java.util.ArrayList;

public class 二叉树中和为某一值的路径 {


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {


        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        help(res,new ArrayList<>(),root,target);
        return res;

    }
    private void help( ArrayList<ArrayList<Integer>> res,ArrayList<Integer> temp,TreeNode root,int target){

        if(root==null){
            return ;
        }
        int x=root.val;

        target-=x;
        temp.add(root.val);
        if(target==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(temp));
        }
        help(res,temp,root.left,target);
        help(res,temp,root.right,target);
        temp.remove(temp.size()-1);



    }

}
