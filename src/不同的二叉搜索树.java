import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树 {


    public static List<TreeNode> generateTrees(int n) {
        if(n==0) {
            return new ArrayList();
        }
        List<TreeNode> res;

        res=help(1,n);
        return res;
    }
    public static List<TreeNode> help(int start,int end){

        List<TreeNode> list=new ArrayList<>();
        if(start<end){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){

            List<TreeNode> left=help(start,i-1);
            List<TreeNode> right=help(i+1,end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    list.add(root);

                }
            }

        }
        return list;


    }

}
