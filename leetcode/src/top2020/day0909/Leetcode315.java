package top2020.day0909;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计算右侧小于当前元素的个数
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 模拟二叉搜索树，并在每个节点设置一个count值表示小于该节点的数量
 */
public class Leetcode315 {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        BSTNode root = null;
        for (int i = 0; i < nums.length; ++i) {
            res.add(i, 0);
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            root = insert(root, i, nums[i], res);
        }
        return res;
    }

    public BSTNode insert(BSTNode root, int i, int val, List<Integer> res) {
        if (root == null) {
            return new BSTNode(val);
        }
        if (val < root.val) {
            root.count++;
            root.left = insert(root.left, i, val, res);
        } else {
            res.set(i, res.get(i) + root.count + 1);
            root.right = insert(root.right, i, val, res);
        }
        return root;
    }


}

class BSTNode {
    BSTNode left;
    BSTNode right;
    int count;
    int val;

    public BSTNode(int val) {
        this.val = val;
    }
}
