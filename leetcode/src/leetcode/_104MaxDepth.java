package leetcode;

/**
 * 二叉树的最大深度
 */
public class _104MaxDepth {

    int max = 0;

    public int maxDepth(TreeNode root) {
        preOrder(root,0);
        return max;
    }

    public void preOrder(TreeNode root,int now) {
        if (root == null) {
            return;
        }
        now++;
        if (now > max) {
            max = now;
        }
        preOrder(root.left,now);
        preOrder(root.right,now);
    }
}
