package classify._4linklist;

import leetcode.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }


    private ListNode merge(ListNode l1, ListNode l2) {
       if (l1 == null) {
           return l2;
       }
       if (l2 == null) {
           return l1;
       }
       if (l1.val < l2.val) {
           l1.next = merge(l1.next,l2);
           return l1;
       } else {
           l2.next = merge(l1,l2.next);
           return l2;
       }
    }
}
