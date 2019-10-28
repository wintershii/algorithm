package aaa;

import java.util.List;

/**
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _147InsertionSortList {

    /**
     * 对链表进行插入排序
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode real = new ListNode(-1);
        real.next = head;
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            if (pre.val < next.val) {
                pre = pre.next;
                next = next.next;
            } else {
                //跳过当前节点.
                pre.next = next.next;
                //保存喜爱个节点.
                ListNode newNex = next.next;
                //回到头结点
                ListNode tmp = real;
                //找到当前节点该放的位置
                while (next.val > tmp.next.val)
                    tmp = tmp.next;
                //放在该节点前面.
                next.next = tmp.next;
                tmp.next = next;
                next = newNex;
            }
        }
        return real.next;
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
