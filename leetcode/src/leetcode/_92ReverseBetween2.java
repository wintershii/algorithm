package leetcode;

/**
 * 翻转链表2
 * 输入m,n
 * 翻转第m到第n个链表中间的所有节点
 */
public class _92ReverseBetween2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        //先找到第m个节点的前一个节点
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
