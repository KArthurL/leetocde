package 剑指offer;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class 重建二叉树 {


    private int index=0;
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }

        return help(0,in.length,map,pre);

    }
    public TreeNode help(int start, int end, Map<Integer,Integer> map, int[] pre){


        if(start>end||index>=pre.length){
            return null;
        }
        int x=pre[index++];
        TreeNode res=new TreeNode(x);
        res.left=help(start,map.get(x)-1,map,pre);
        res.right=help(map.get(x)+1,end,map,pre);
       return res;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        LinkedList<Integer> queue=new LinkedList<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        for(int x:preorder)
        {
            queue.offer(x);
        }
        int size=map.size();
        return help(0,size-1,map,queue);
    }
    public TreeNode help(int start,int end,HashMap<Integer,Integer> map,LinkedList queue)
    {
        if(queue.isEmpty()||end<start) {
            return null;
        }
        int v=(int)queue.poll();
        int index=map.get(v);
        TreeNode res=new TreeNode(v);
        res.left=help(start,index-1,map,queue);
        res.right=help(index+1,end,map,queue);
        return res;
    }

    public  TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }


}
