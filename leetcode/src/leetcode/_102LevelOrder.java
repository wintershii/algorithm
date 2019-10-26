package leetcode;

import java.util.*;

/**
 * 层序遍历
 * 使用队列
 * 外循环,队列不为空
 * 内循环, 先获取队列当前的size,再进行内循环.
 */
public class _102LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }
}
