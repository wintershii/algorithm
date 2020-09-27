package top2020.day0927;

import leetcode.TreeNode;

public class Leetcode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        while (true) {
            if (root == null || root.val == val) return root;
            root = root.val > val ? root.left : root.right;
        }
    }
}
