package p05;

import leetcode.TreeNode;

public class IsSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return solve(root.left, root.right);
    }

    public boolean solve(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return solve(left.left, right.right) && solve(left.right, right.left);
    }
}
