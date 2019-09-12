package _8tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的路径之和
 * 给定一个二叉树与整数sum, 找出所有从根节点到叶节点的路径, 这些路径上的节点值累加和为sum
 */
public class _1SumPathOfTree {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        search(root,list,sum,root.val);
        return res;
    }

    public void search(TreeNode root, List<Integer> list, int sum, int now) {
        if (root.left == null && root.right == null) {
            if (sum == now) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            search(root.left,list,sum,now+root.left.val);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            search(root.right,list,sum,now+root.right.val);
            list.remove(list.size()-1);
        }
    }
}
