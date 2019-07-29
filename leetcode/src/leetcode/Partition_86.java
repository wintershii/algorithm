package leetcode;

public class Partition_86 {

    public ListNode partition(ListNode head, int x) {
        ListNode tmp1 = new ListNode(0);
        ListNode tmp2 = new ListNode(0);
        ListNode node1 = tmp1;
        ListNode node2 = tmp2;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                node1.next = new ListNode(node.val);
                node1 = node1.next;
            } else {
                node2.next = new ListNode(node.val);
                node2 = node2.next;
            }
            node = node.next;
        }
        ListNode tail = tmp1;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = tmp2.next;
        return tmp1.next;
    }
}
