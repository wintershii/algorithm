package leetcode;

/**
 * 判断是否是相同的树
 * 直接递归, 如果两边都是null, 返回true
 * 如果两边都不是true 且值相等, 则递归证两棵树各自的左右节点是不是同一棵树
 * 否则直接返回false
 */
public class _100IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        } else {
            return false;
        }
    }
}
