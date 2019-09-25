package leetcode;


/**
 * 删除链表的倒数第n个节点
 * 解法 : 快慢指针
 */
public class _19RemoveNthRormEnd{
    public static void main(String[] args) {
        ListNode head = new _19RemoveNthRormEnd().create(new int[]{1});
        new _19RemoveNthRormEnd().print(head);
        new _19RemoveNthRormEnd().removeNthFromEnd(head,1);
        new _19RemoveNthRormEnd().print(head);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode pNode = head;
        ListNode qNode = head;
        ListNode pre = head;
        for (int i = 0; i < n; i++) {
            pNode = pNode.next;
        }
        while (pNode != null) {
            if (pNode.next != null) {
                pre = pre.next;
            }
            pNode = pNode.next;
            qNode = qNode.next;
        }
        if (qNode.next == null) {
            pre.next = null;
        } else {
            qNode.val = qNode.next.val;
            qNode.next = qNode.next.next;
        }
        return head;
    }

    public ListNode create(int[] arr) {
        ListNode head = new ListNode(arr[0]);;
        ListNode pre = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            pre.next = tmp;
            pre = tmp;
        }
        pre.next = null;
        return head;
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

