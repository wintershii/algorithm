package leetcode;

public class sortedListToBST_109 {
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
