package top2020.day0905;

/**
 * 两数相加，两个链表相加。返回对应结果的链表形式
 * 进位位carry，保留l1的尾部
 * 判断l1为空，l2为空，l1，l2都为空的情况
 */
public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l2 == null && l1 != null) {
            return l1;
        }
        ListNode res = l1;
        ListNode behind = null;
        boolean carry = false;
        while (l1 != null && l2 != null) {
            l1.val += l2.val;
            if (carry) {
                l1.val++;
                carry = false;
            }
            if (l1.val >= 10) {
                l1.val %= 10;
                carry = true;
            }
            if (l1.next == null) {
                behind = l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2 == null && l1 != null) {
            if (carry) {
                l1.val++;
                while (l1.val >= 10) {
                    l1.val %= 10;
                    if (l1.next == null) {
                        l1.next = new ListNode(0);
                    }
                    l1.next.val++;
                    l1 = l1.next;
                }
            }
        }

        if (l1 == null && l2 != null) {
            ListNode connect = l2;
            if (carry) {
                l2.val++;
                while (l2.val >= 10) {
                    l2.val %= 10;
                    if (l2.next == null) {
                        l2.next = new ListNode(0);
                    }
                    l2.next.val++;
                    l2 = l2.next;
                }
            }
            behind.next = connect;
        }
        if (l1 == null && l2 == null) {
            if (carry) {
                l1 = new ListNode(1);
                behind.next = l1;
            }
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
