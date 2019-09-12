package _8tree;

import leetcode.TreeNode;

/**
 * 最近的公共祖先
 * 已知二叉树, 求二叉树中给定的两个节点的最近公共祖先
 * 最近公共祖先 : 两节点v与w的最近公共祖先u, 满足在树上最低(离根最远),且v,w两个节点都是u的子孙
 */
public class _LowestCommonAncestor {

    /**
     * 思路一 : 深搜两个节点的路径, 然后保存并找到两个序列中最后的公共元素
     * 思路二 : 后序遍历, 并保存, 然后进行比较判断(其实就是将问题分到了两颗子树上, 如果左子树和右子树中都没有公共祖先, 那公共祖先就是当前的根)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

}
