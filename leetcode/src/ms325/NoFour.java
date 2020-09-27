package ms325;

import leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NoFour {
    public static void main(String[] args) {
        TreeNode root = new NoFour().build(new int[]{1,2,3,-1,-1,4,-1,-1});
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left);
        System.out.println(root.left.right);
        System.out.println(root.right.left);
        System.out.println(root.right.right);
        new NoFour().postOrder(root);
    }

    public TreeNode build(int[] arr) {
         int index = 1;
         Queue<TreeNode> queue = new LinkedList<>();
         TreeNode root = new TreeNode(arr[0]);
         queue.offer(root);
         while (!queue.isEmpty() && index < arr.length) {
             TreeNode node = queue.poll();
             if (arr[index] == -1) {
                 node.left = null;
             } else {
                 node.left = new TreeNode(arr[index]);
                 queue.offer(node.left);
             }
             index++;
             if (index >= arr.length || arr[index] == -1) {
                 node.right = null;
             } else {
                 node.right = new TreeNode(arr[index]);
                 queue.offer(node.right);
             }
             index++;
         }
         return root;
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.right);
        postOrder(root.left);
        System.out.print(root.val + " ");
    }
}
