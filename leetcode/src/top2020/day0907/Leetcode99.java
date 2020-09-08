package top2020.day0907;

import leetcode.TreeNode;

/**
 * 恢复二叉搜索树
 * 二叉搜索树中有两个节点被错误的交换了，还原
 * 思路：中序遍历，保存错误的两个节点，最后还原
 */
public class Leetcode99 {

    TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    public void inorder(TreeNode root) {
        if (root == null)   return;
        inorder(root.left);
        if (pre != null && root.val < pre.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}
