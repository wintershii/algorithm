package leetcode;

/**
 * 分隔链表
 */
public class _86Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode tmp1 = new ListNode(0);
        ListNode tmp2 = new ListNode(0);
        ListNode node1 = tmp1;
        ListNode node2 = tmp2;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                node1.next = node;
                node = node.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = node;
                node = node.next;
                node2 = node2.next;
                node2.next = null;
            }

        }
        node1.next = tmp2.next;
        return tmp1.next;
    }
}
