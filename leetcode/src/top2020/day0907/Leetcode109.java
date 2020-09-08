package top2020.day0907;

import leetcode.ListNode;
import leetcode.TreeNode;

/**
 * 有序链表转二叉搜索树
 */
public class Leetcode109 {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head);
    }

    public TreeNode build(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode quick = head;
        ListNode slow = head;
        ListNode pre = null;
        while (quick != null && quick.next != null) {
            pre = slow;
            quick = quick.next.next;
            slow = slow.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = build(head);
        root.right = build(slow.next);
        return root;
    }
}
