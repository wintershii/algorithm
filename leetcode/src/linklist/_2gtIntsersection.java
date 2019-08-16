package linklist;

import leetcode.ListNode;

/**
 * 求两条链表的相交链表
 * 1.使用HashSet,查重
 */
public class _2gtIntsersection {

    /**
     * 先计算出两个链表长度上的差, 移动到同一个位置上, 然后开始遍历
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getListLength(headA);
        int len2 = getListLength(headB);
        int d = Math.abs(len1 - len2);
        if (len1 > len2) {
            while (headA != null && d-- > 0) {
                headA = headA.next;
            }
        } else {
            while (headB != null && d-- > 0) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getListLength(ListNode list) {
        int res = 0;
        while (list != null) {
            list = list.next;
            res++;
        }
        return res;
    }
}
