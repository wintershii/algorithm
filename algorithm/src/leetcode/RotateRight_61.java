package leetcode;

public class RotateRight_61 {

    public static void main(String[] args) {
        ListNode head = new RemoveNthRormEnd_19().create(new int[]{});
        ListNode newHead = new RotateRight_61().rotateRight(head,3);
        new RemoveNthRormEnd_19().print(newHead);
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode tmp = head;
        ListNode rek = head;
        ListNode test = head;
        int len = 0;
        while (test != null){
            test = test.next;
            ++len;
        }
        if (len == 0) {
            return null;
        }
        k = k > len ? k % len : k;
        if (k == 0) {
            return head;
        }

        for (int i = 0; i < k-1; i++) {
            tmp = tmp.next;
        }
        while (tmp.next != null) {
            rek = rek.next;
            tmp = tmp.next;
        }
        tmp.next = head;
        while (head.next != rek) {
            head = head.next;
        }
        head.next = null;
        return rek;
    }
}
