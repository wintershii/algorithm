package leetcode;

public class DeleteDuplicates2_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {

                while (node.next.next != null && node.next.val == node.next.next.val) {
                    node.next = node.next.next;
                }


                if (pre == null) {
                    head = node.next.next;
                    node = head;
                    if (head == null) {
                        return head;
                    }
                } else {
                    pre.next = node.next.next;
                    node = pre.next;
                    if (node == null) {
                        return head;
                    }
                }
                continue;
            }
            pre = node;
            node = node.next;
        }
        return head;
    }



}
