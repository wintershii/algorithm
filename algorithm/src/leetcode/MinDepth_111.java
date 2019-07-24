package leetcode;

public class MinDepth_111 {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        search(root,1);
        return min;
    }

    public  void search(TreeNode root,int depth) {
        if (root.left == null&& root.right == null) {
            min = Math.min(min, depth);
            return;
        }
        if (root.left != null) {
            search(root.left,depth+1);
        }
        if (root.right != null) {
            search(root.right,depth+1);
        }

    }
}
