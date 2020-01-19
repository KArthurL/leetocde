public class 二叉树最大路径和 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        help(root);
        return res;
    }

    private int help(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(help(root.left), 0);
        int right = Math.max(help(root.right), 0);
        res = Math.max(res, root.val + left + right);//这是真的牛逼
        return root.val + Math.max(left, right);
    }

}