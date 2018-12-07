package list;

/**
 * 反转链表
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l = MergeLinkedList.createList();
        MergeLinkedList.printList(l);
        ListNode l2 = new ReverseLinkedList().reverse(l);
        MergeLinkedList.printList(l2);
    }


    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        new ReverseLinkedList().reverseList(head);
        return node;
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next = null;
        node.next = head;
        return head;
    }
}
