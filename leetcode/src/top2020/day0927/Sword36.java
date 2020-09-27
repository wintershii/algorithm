package top2020.day0927;

public class Sword36 {

    Node pre = null, head = null;

    /**
     * 方法1：保存pre和head节点进行中序遍历。
     * 每次将root.left指向pre，pre.right指向root，更行pre，找到head。
     * 最后连接成环
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        helper(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    public void helper(Node root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        pre = root;
        helper(root.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};