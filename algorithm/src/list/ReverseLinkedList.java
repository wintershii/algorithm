package list;

/**
 * 题目:反转链表(递归与迭代两种方式)
 * 来源:leetcode字节跳动专栏
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l = MergeLinkedList.createList();
        MergeLinkedList.printList(l);
        ListNode l2 = new ReverseLinkedList().reverse(l);
        MergeLinkedList.printList(l2);
    }


    /**
     * 迭代反转链表的答案
     * @param head
     * @return
     */
    public ListNode nonRecReverseList(ListNode head) {
        ListNode newHead = null;

        //不断取出和向后移动头结点
        //并将头节点连接到新头结点后面
        while (head != null) {

            //单独取出下一个节点
            ListNode next = head.next;

            //将头结点连接到新头结点后面
            head.next = newHead;
            newHead = head;

            //向后移动头节点
            head = next;
        }
        return newHead;
    }


    /**
     * 自己实现的递归反转
     * @param head
     * @return
     */
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
