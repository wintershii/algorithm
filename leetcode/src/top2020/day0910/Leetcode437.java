package top2020.day0910;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和3
 * 二叉树的前缀和(回溯)
 */
public class Leetcode437 {

    Map<Integer, Integer> map;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        map = new HashMap<>();
        map.put(0, 1);
        int res = helper(root, sum, 0);
        return res;
    }

    public int helper(TreeNode root, int sum, int pre) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        pre += root.val;
        res += map.getOrDefault(pre - sum, 0);
        map.put(pre, map.getOrDefault(pre, 0) + 1);
        res += helper(root.left, sum, pre) + helper(root.right, sum, pre);
        map.put(pre, map.getOrDefault(pre, 0) - 1);
        return res;
    }
}
