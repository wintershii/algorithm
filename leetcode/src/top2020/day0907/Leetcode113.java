package top2020.day0907;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路经总和2
 */
public class Leetcode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        helper(res, root.val, sum, root, list);
        return res;
    }

    public void helper(List<List<Integer>> res, int now, int sum, TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            if (now == sum) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            helper(res, now+root.left.val, sum, root.left, list);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            helper(res, now+root.right.val, sum, root.right, list);
            list.remove(list.size()-1);
        }
    }
}
