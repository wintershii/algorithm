package leetcode;

/**
 * K个一组翻转链表
 */
public class _25ReverseKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        new _25ReverseKGroup().reverseKGroup(head,4);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(0);
        ListNode pre = node;
        ListNode cur = head;
        ListNode nex = null;
        node.next = head;
        int length = 0;
        //首先计算链表长度
        while(head != null) {
            length++;
            head = head.next;
        }
        /**
         * 外部进行循环,总共翻转的次数为length/k
         */
        while (length >= k) {
            /**
             * 内部循环进行翻转
             */
            for (int i = 1; i < k; ++i) {
                nex = cur.next;
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
            }
            pre = cur;
            cur = pre.next;
            length -= k;
        }
        return node.next;
    }
}
