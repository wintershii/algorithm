package leetcode;

public class _110IsBalanced {
    //如果root是空,返回true
    //两子树高度差小于等于1,并且其左右子树也是平衡的.
    public boolean isBalanced(TreeNode root) {
        return root == null || (Math.abs(depth(root.right) - depth(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        //深度等于,1+左右子树最大值,递归调用
        return 1 + Math.max(depth(root.left),depth(root.right));
    }
}
