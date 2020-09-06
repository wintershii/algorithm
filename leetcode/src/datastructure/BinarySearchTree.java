package datastructure;

public class BinarySearchTree {
    TreeNode root;
    class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer val;
    }

    public void insert(int key) {
        TreeNode node = new TreeNode();
        node.val = key;
        if (root == null) {
            root = node;
        } else {
            TreeNode cur = root;
            while (true) {
                TreeNode parent = cur;
                if (cur.val > key) {
                    cur = cur.left;
                    if (cur == null) {
                        parent.left = node;
                        return;
                    }
                }
                if (cur.val < key) {
                    cur = cur.right;
                    if (cur == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    public TreeNode find(int key) {
        TreeNode cur = root;
        while (cur.val != key) {
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
            if (cur == null)
                return null;
        }
        return cur;
    }

    public void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        travel(root.left);
        System.out.print(root.val + " ");
        travel(root.right);
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(2);
        bst.insert(1);
        bst.insert(7);
        bst.insert(4);
        bst.insert(-3);
        bst.travel(bst.root);
        System.out.println(bst.find(-3));
    }
}
