package classify._4linklist;

import leetcode.ListNode;

/**
 * 链表求环
 * 1.使用HashSet, 查重
 * 2.快慢指针
 */
public class _3ListCycle {

    /**
     * 快慢指针 + 数学问题
     * @param head
     * @return
     */
    public ListNode detectNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == slow) {
                meet = fast;
                break;
            }
        }
        if (meet == null) {
            return null;
        }
        while (head != null && meet != null) {
            if (head == meet) {
                return head;
            }
            head = head.next;
            meet = meet.next;
        }
        return null;
    }
}
