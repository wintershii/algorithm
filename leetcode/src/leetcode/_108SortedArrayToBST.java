package leetcode;

/**
 * 有序数组转二叉搜索树
 */
public class _108SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }

    private static TreeNode build(int[] num, int start,  int end) {
        if (start > end) {
            return null;
        }
        //二分,获取到根节点
        int mid = (start + end)/2 + start;
        TreeNode root = new TreeNode(num[mid]);
        //分别获取左右子树
        root.left = build(num,start,mid-1);
        root.right = build(num,mid+1,end);
        return root;
    }
}
