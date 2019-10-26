package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 锯齿形层次遍历二叉树, 与层次遍历思想类似,只是加了一个level
 */
public class _103ZigzagLevelOrder {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //增加level,每过一层level+1
        int level = 1;
        while ( !queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                //如果是奇数层,加在队列后面
                if (level % 2 == 1) list.add(cur.val);
                else list.add(0,cur.val);//否则加在队列前面
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            level++;
            res.add(list);
        }
        return res;
    }
}
