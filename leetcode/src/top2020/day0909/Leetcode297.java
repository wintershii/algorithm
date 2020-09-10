package top2020.day0909;

import leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 */
public class Leetcode297 {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = doSerialize(root, sb);
        return res.toString();
    }

    public StringBuilder doSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb.append("#");
        }
        sb.append(root.val);
        sb.append(",");
        sb = doSerialize(root.left, sb);
        sb.append(",");
        sb = doSerialize(root.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strs));
        return doDeserialize(list);
    }

    public TreeNode doDeserialize(List<String> list) {
        if (list.get(0).equals("#")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = doDeserialize(list);
        root.right = doDeserialize(list);
        return root;
    }
}
