package leetcode;

public class BuildTree_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }

    public TreeNode build(int preLeft, int preRight, int inLeft,int inRight, int[] preorder, int[] inorder) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRoot = inLeft;
        while (inRoot < inRight && inorder[inRoot] != preorder[preLeft])
            inRoot++;
        int left = inRoot - inLeft;
        root.left = build(preLeft+1,preLeft+left,inLeft,inRoot-1,preorder,inorder);
        root.right = build(preLeft+left+1,preRight,inRoot+1,inRight,preorder,inorder);
        return root;
    }
}
