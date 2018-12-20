package list;

import java.util.Arrays;

/**
 * 题目：合并ｋ个排序链表
 * 来源:leetcode字节跳动专栏
 */
public class MergeKLinkedLists {
    public static void main(String[] args) {
        ListNode l1 = MergeLinkedList.createList();
        ListNode l2 = MergeLinkedList.createList();
        ListNode l3 = MergeLinkedList.createList();
        MergeLinkedList.printList(l1);
        MergeLinkedList.printList(l2);
        MergeLinkedList.printList(l3);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        MergeLinkedList.printList(new MergeKLinkedLists().mergeKLists(lists));

    }

    /**
     * 自己写的,基于两个链表合并,改写
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = null;

        for (int i = 0; i < lists.length; i++) {
            if (i == 0) {
                result = MergeLinkedList.mergeTwoLists(lists[0],lists[1]);
            }
            if (i >= 2) {
                result = MergeLinkedList.mergeTwoLists(result,lists[i]);
            }
        }
        return result;
    }


}
