package microsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _297SerializeTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        String str = new _297SerializeTree().serialize(a);
        System.out.println(str);
        //TreeNode res = new _297SerializeTree().deserialize(str);

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return realizeSe(sb,root).toString();
    }

    private StringBuilder realizeSe(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("#");
            return sb;
        }
        sb.append(root.val);
        sb.append(",");
        sb = realizeSe(sb,root.left);
        sb.append(",");
        sb = realizeSe(sb,root.right);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));
        return realizeDe(list);
    }

    private TreeNode realizeDe(List<String> data) {
        if (data.get(0).equals("#")) {
            data.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        TreeNode left = realizeDe(data);
        TreeNode right = realizeDe(data);
        root.left = left;
        root.right = right;
        return root;
    }
}

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}