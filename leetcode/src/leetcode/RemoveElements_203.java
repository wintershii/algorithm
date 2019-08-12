package leetcode;

public class RemoveElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head = pre.next;
            } else {
                head = head.next;
                pre = pre.next;
            }
        }
        return node.next;
    }
}
