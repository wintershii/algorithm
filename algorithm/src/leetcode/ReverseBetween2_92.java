package leetcode;

public class ReverseBetween2_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m;  i  < n; i++) {
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return node.next;
    }
}
