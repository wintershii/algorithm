package leetcode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _112HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null) {
            return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
        } else if (root.left != null) {
            return hasPathSum(root.left,sum-root.val);
        } else if (root.right != null)  {
            return hasPathSum(root.right,sum-root.val);
        } else {
            return root.val == sum;
        }

    }

/*    public boolean hasValue(TreeNode root, int value) {
//        if (root != null && value == 0) {
//            return false;
//        }
//        if (root == null && value == 0) {
//            return true;
//        }
//        if (root == null) {
//            return false;
//        }
//        if (root.left == null && root.right == null) {
//            if (root.val ==  value) {
//                return true;
//            }
//            return false;
//        }

        if (root.left != null && root.right != null) {
            return hasValue(root.left,value-root.val) || hasValue(root.right,value-root.val);
        } else if (root.left != null) {
            return hasValue(root.left,value-root.val);
        } else if (root.right != null)  {
            return hasValue(root.right,value-root.val);
        } else {
            return root.val == value;
        }
//        return hasValue(root.left,value-root.val) || hasValue(root.right,value-root.val);
    }*/

}
