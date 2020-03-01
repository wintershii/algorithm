package classify.list;

import java.util.Scanner;

/**
 * 题目:合并两个有序链表
 * 来源:leetcode字节跳动专栏
 */
public class MergeLinkedList {

    public static void main(String[] args) {
        ListNode l1 = createList();
        ListNode l2 = createList();
        printList(l1);
        printList(l2);

        ListNode l3 = mergeTwoLists(l1,l2);
        printList(l3);

    }

    /**
     * 合并两链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = l1.val < l2.val ? l1 : l2;
        ListNode n1 = l1;
        ListNode n2 = l2;
        if (node == n1) {
            n1 = n1.next;
        } else {
            n2 = n2.next;
        }
        ListNode temp = node;
        while (n1 != null && n2 != null) {
            temp.next = n1.val < n2.val ? n1 : n2;
            temp = temp.next;
            if (temp == n1) {
                n1 = n1.next;
            } else {
                n2 = n2.next;
            }
        }
        if (n1 == null) {
            temp.next = n2;
        }
        if (n2 == null) {
            temp.next = n1;
        }
        return node;
    }

    /**
     * 构造链表
     * @return
     */
    public static ListNode createList() {
        System.out.print("请输入数据:");
        Scanner scan = new Scanner(System.in);
        ListNode node = new ListNode(0);
        ListNode book = node;
        int val;

        while ((val = scan.nextInt()) != -1) {
            ListNode temp = new ListNode(val);
            node.next = temp;
            node = node.next;
        }
        return book.next;
    }

    /**
     *
     */
    public static void printList(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "  ");
            l = l.next;
        }
        System.out.println();
    }
}

