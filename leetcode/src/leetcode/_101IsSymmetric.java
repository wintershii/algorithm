package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树
 */
public class _101IsSymmetric {
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left,root.right);
    }

    private boolean compare(TreeNode lNode, TreeNode rNode) {
        //都为空
        if (lNode == null && rNode == null) {
            return true;
        }
        //某个是空,另一个不是
        if (lNode == null || rNode == null) {
            return false;
        }
        //值不相等
        if (lNode.val != rNode.val) {
            return false;
        }
        //左边的右子树和右边的左子树. 左边的左子树和右边的右子树
        return compare(lNode.left,rNode.right) && compare(rNode.left,lNode.right);
    }


}
