package classify._4linklist;

import leetcode.ListNode;

/**
 * 链表划分
 * 给链表和一个数值x, 将原来小于x的节点放在大于或等于x的节点前, 且保持这些节点原来的相对位置
 */
public class _4PartitionList {
    /**
     * 建立两个辅助头节点, 一个存储小于x的, 另一个存储大于等于x的
     * 最后将两个链表连接
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);
        ListNode lessPtr = lessHead;
        ListNode morePtr = moreHead;
        while (head != null) {
            if (head.val < x) {
                lessPtr.next = head;
                lessPtr = lessPtr.next;
            } else {
                morePtr.next = head;
                morePtr = morePtr.next;
            }
            head = head.next;
        }
        lessPtr.next = moreHead.next;
        morePtr.next = null;
        return lessHead.next;
    }
}
