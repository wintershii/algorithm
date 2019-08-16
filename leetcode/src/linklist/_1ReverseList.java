package linklist;

import leetcode.ListNode;

/**
 * 链表逆置
 */
public class _1ReverseList {

    /**
     * 翻转链表
     * 1.备份一下当前节点的next
     * 2.将当前节点的next指向newHead
     * 2.更新head和newHead的值
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    /**
     * 从链表的位置m到n逆置链表
     * 1.找四个关键节点  1.逆置前驱 2.逆置头节点 3.逆置尾节点 4.逆置后继
     * 2.移动m-1找到头结点
     * 3.
     */
    public ListNode mnReverse(ListNode head, int m, int n) {
        int change = n - m + 1;
        ListNode preHead = null;
        ListNode res = head;
        while (head != null && --m > 0) {
            preHead = head;
            head = head.next;
        }
        ListNode moTail = head;
        ListNode newHead = null;
        while (head != null && change > 0) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
            change--;
        }
        moTail.next = head;
        if (preHead != null) {
            preHead.next = newHead;
        } else {
            res = newHead;
        }
        return res;
    }
}
