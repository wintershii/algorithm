package leetcode;

import java.util.*;

public class InOrderTraversal_94 {

    private List<Integer> list = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println(new InOrderTraversal_94().inorderTraversal(new TreeNode(2)));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root  = root.right;
            }
        }
        return res;
    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        inOrder(root);
        return list;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
