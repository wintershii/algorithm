package leetcode;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new RemoveNthRormEnd_19().create(new int[]{1,2,3,4});
        new RemoveNthRormEnd_19().print(head);
        head = new SwapPairs().swapPairs(head);
        new RemoveNthRormEnd_19().print(head);
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
