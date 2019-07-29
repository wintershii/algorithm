package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class IsSymmetric_101 {
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left,root.right);
    }

    private boolean compare(TreeNode lNode, TreeNode rNode) {
        if (lNode == null && rNode == null) {
            return true;
        }
        if (lNode == null || rNode == null) {
            return false;
        }
        if (lNode.val != rNode.val) {
            return false;
        }
        return compare(lNode.left,rNode.right) && compare(rNode.left,lNode.right);
    }


}
