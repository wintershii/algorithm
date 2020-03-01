package classify.list;

import java.util.HashMap;

/**
 * 题目：环形链表找环
 * 来源:leetcode字节跳动专栏
 */
public class DetectCircleList {
    public static void main(String[] args) {

    }

    /**
     * 自己写的解法
     * @param head
     * @return
     */
    public ListNode myDetectNode(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode temp = head;
        int index = 1;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            map.put(temp,index++);
            temp = temp.next;
        }
        return null;
    }


    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectNode(ListNode head) {
        ListNode fast;
        ListNode slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
