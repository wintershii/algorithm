package leetcode;

/**
 * 验证二叉排序树
 * 如果节点为空, 返回true
 * 节点不为空, 先判断左子树是不是二叉搜索树, 如果是, 比较last只是否小于当前节点值, 如果不是, 则不是二叉搜索书,返回false
 * 如果last小于当前值, 则更新last为当前值, 并验证当前节点的右子树是否是二叉搜索树
 */
public class _98IsValidBST {

    double last = -Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

}
