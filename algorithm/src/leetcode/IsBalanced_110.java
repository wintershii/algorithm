package leetcode;

public class IsBalanced_110 {
    public boolean isBalanced(TreeNode root) {
        return root == null || (Math.abs(depth(root.right) - depth(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left),depth(root.right));
    }
}
