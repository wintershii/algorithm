package leetcode;

public class SortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }

    private static TreeNode build(int[] num, int start,  int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end)/2 + start;
        TreeNode root = new TreeNode(num[mid]);
        root.left = build(num,start,mid-1);
        root.right = build(num,mid+1,end);
        return root;
    }
}
