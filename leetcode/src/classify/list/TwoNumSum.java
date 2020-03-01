package classify.list;

/**
 * 题目:两数相加
 * 来源:leetcode字节跳动专栏
 */
public class TwoNumSum {
    public static void main(String[] args) {
        ListNode l1 = MergeLinkedList.createList();
        ListNode l2 = MergeLinkedList.createList();
        MergeLinkedList.printList(l1);
        MergeLinkedList.printList(l2);
        ListNode result = new TwoNumSum().addTwoNumbers(l1,l2);
        MergeLinkedList.printList(result);
    }

    /**
     * 自己写的
     * 思路:挨个相加,结果放到l1中
     * 本来想的是新建一条链表,但是有点费空间
     * 所以把结果放在l1中,返回l1的头.但是有个问题就是:当5+5=10时,没有足够的长度存储结果
     *
     * 更新:通过了
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        boolean carry = false;
        ListNode before = null;
        while (l1 != null && l2 != null) {
            if (carry) {
                l1.val++;
                carry = false;
            }
            l1.val += l2.val;
            if (l1.val >= 10) {
                l1.val %= 10;
                carry = true;
            }
            if (l1.next == null) {
                before = l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        /**
         * 后面考虑到的情况
         */

        if (l2 == null && l1 != null) {
            if (carry) {
                l1.val++;
                while (l1.val >= 10) {
                    l1.val %= 10;
                    if (l1.next == null) {
                        l1.next = new ListNode(0);
                    }
                    l1 = l1.next;
                    l1.val++;
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
                    l2 = l2.next;
                    l2.val++;
                }
            }
            before.next = connect;
        }


        if (l1 == null && l2 == null) {
            if (carry) {
                l1 = new ListNode(1);
                before.next = l1;
            }
        }

        return result;

    }
}

