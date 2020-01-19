package 剑指offer;

public class 二叉树的下一个结点 {



    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right!=null){

            TreeLinkNode res=pNode.right;
            while(res.left!=null) {
                res = res.left;
            }
            return res;

        }else{
            TreeLinkNode res=pNode.next;
            if(res==null){
                return null;
            }
            while(pNode.next!=null){
                if(pNode.next.left==pNode){
                    return pNode.next;
                }
                pNode=pNode.next;
            }
            return null;
        }

    }

}
