package leetcode;


/**
 * 利用前序遍历和中序遍历建立二叉树
 */
public class _105BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //传入前序和中序,在数组中的开始位置和结束位置
        return build2(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }


    //1.根据前序和中序得到二叉树
    public TreeNode build(int preLeft, int preRight, int inLeft,int inRight, int[] preorder, int[] inorder) {
        //返回条件:左边界大于右边界
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        //获得前序的第一个,建立根节点,其实就是返回这个节点
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRoot = inLeft;
        //找到根节点在中序遍历中的位置
        while (inRoot < inRight && inorder[inRoot] != preorder[preLeft])
            inRoot++;
        //左子树元素数目
        int left = inRoot - inLeft;
        //分别递归获取到root的左右子树
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
