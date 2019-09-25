package leetcode;

/**
 * 两两交换链表节点
 */
public class _24SwapPairs {
    public static void main(String[] args) {
        ListNode head = new _19RemoveNthRormEnd().create(new int[]{1,2,3,4});
        new _19RemoveNthRormEnd().print(head);
        head = new _24SwapPairs().swapPairs(head);
        new _19RemoveNthRormEnd().print(head);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode now = head;
        ListNode pre = null;
        while (now != null && now.next != null) {
            if (now == head) {
                head = now.next;
            }
            if (pre != null) {
                pre.next = now.next;
            }
            ListNode tmp = now.next.next;
            now.next.next = now;
            now.next = tmp;
            pre = now;
            now = now.next;
        }
        return head;
    }
}
