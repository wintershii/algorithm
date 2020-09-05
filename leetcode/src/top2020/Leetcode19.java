package top2020;

/**
 * 删除链表的倒数第n个节点
 * 快慢指针
 */
public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quick = head;
        ListNode slow = head;
        ListNode pre = null;
        for (int i = 0; i < n; ++i) {
            quick = quick.next;
        }
        while (quick != null) {
            pre = slow;
            quick = quick.next;
            slow = slow.next;
        }
        if (pre == null) {
            return head.next;
        } else {
            if (slow.next == null) {
                pre.next = null;
            } else {
                slow.val = slow.next.val;
                slow.next = slow.next.next;
            }

        }
        return head;
    }
}
