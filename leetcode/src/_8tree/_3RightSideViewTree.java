package _8tree;

import leetcode.TreeNode;

import java.util.*;

/**
 * 侧面观察二叉树
 * 给定一个二叉树, jiashe从二叉树的右侧观察它, 将观察到的节点按照从上到下的顺序输出
 */
public class _3RightSideViewTree {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmp = queue.poll();
                if (i == size - 1) {
                    res.add(tmp.val);
                }
                if (tmp.left != null) {
                    queue.addLast(tmp.left);
                }
                if (tmp.right != null) {
                    queue.addLast(tmp.right);
                }
            }
        }
        return res;
    }


}
