package leetcode;

/**
 * 二叉搜索树的最近公共祖先
 *
 */
public class _LowerSeacherCommon {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if ((p.val > root.val && q.val < root.val) || (q.val > root.val && p.val < root.val)) {
            return root;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        return null;
    }
}
