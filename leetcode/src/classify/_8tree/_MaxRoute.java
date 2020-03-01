package classify._8tree;

import leetcode.TreeNode;

/**
 * 2019.11.7头条三面面试题
 * 没A出来当时..
 */
public class _MaxRoute {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        search(root);
        return max;
    }

    private int search(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(search(root.left),0);
        int right = Math.max(search(root.right),0);
        max = Math.max(max,root.val + left + right);
        return root.val + Math.max(left,right);
    }
}
