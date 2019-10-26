package leetcode;

/**
 * 有序链表转二叉搜索树'
 * 每次通过快慢指针获取链表的中间节点
 */
public class _109sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = head;
        ListNode slow =  pre.next;
        ListNode quick = slow.next;
        while (quick != null && quick.next != null) {
            pre = pre.next;
            slow = pre.next;
            quick = quick.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
