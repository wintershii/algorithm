package top2020.day0907;

import leetcode.TreeNode;

public class Leetcode98 {

    double last = -Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (root.val > last) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
