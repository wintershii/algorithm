package top2020.day0927;

import leetcode.TreeNode;

public class Leetcode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode parent = root,p = root;
        while(p != null){
            parent = p;
            p = p.val < val ? p.right : p.left;
        }
        if(parent.val < val){
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }
        return root;
    }
}
