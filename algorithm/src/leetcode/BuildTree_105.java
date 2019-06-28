package leetcode;


public class BuildTree_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build2(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }


    //1.根据前序和中序得到二叉树
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

    //2.根据中序和后序得到二叉树
    public TreeNode build2(int inLeft, int inRight, int postLeft, int postRight, int[] inorder, int[] postorder) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int inRoot = inLeft;
        while (inRoot < inRight && inorder[inRoot] != postorder[postRight])
            inRoot++;
        int left = inRoot - inLeft;
        root.left = build2(inLeft,inRoot-1,postLeft,postLeft+left,inorder,postorder);
        root.right = build2(inRoot+1,inRight,postLeft+left+1,postRight-1,inorder,postorder);
        return root;
    }
}
