package _4linklist;

import leetcode.ListNode;

/**
 * 两个排序链表的排序
 */
public class _6MergeList {

    /**
     * 两个链表合并
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode head = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return tmp.next;
    }

    /**
     * k个有序链表的合并
     * 1.暴力合并, 1和2合并然后和3..
     * 2.利用集合保存链表节点, 再排序结合, 最后形成一个同一的链表
     * 3.分治的思想
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoList(lists[0],lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] list1 = new ListNode[mid+1];
        ListNode[] list2 = new ListNode[mid+1];
        int k = 0;
        for (int i = 0; i < mid; ++i) {
            list1[k++] = lists[i];
        }
        k = 0;
        for (int i = mid; i < lists.length; ++i) {
            list2[k++] = lists[i];
        }
        ListNode l1 = mergeKLists(list1);
        ListNode l2 = mergeKLists(list2);
        return mergeTwoList(l1,l2);
    }


}
