package leetcode;

/**
 * 删除链表中的重复字符2
 * 只保留没有重复的数字
 */
public class _82DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode node = head;
        //遍历链表
        while (node.next != null) {
            //如果出现重复
            if (node.val == node.next.val) {

                while (node.next.next != null && node.next.val == node.next.next.val) {
                    node.next = node.next.next;
                }


                if (pre == null) {
                    head = node.next.next;
                    node = head;
                    if (head == null) {
                        return head;
                    }
                } else {
                    pre.next = node.next.next;
                    node = pre.next;
                    if (node == null) {
                        return head;
                    }
                }
                continue;
            }
            pre = node;
            node = node.next;
        }
        return head;
    }



}
