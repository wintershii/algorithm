package list;

import java.util.HashSet;

public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    /**
     * 占用了一个set的解法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode myGetIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        if (headA == headB) {
            return headA;
        }
        while (headA != null || headB != null) {
            if (set.contains(headA)) {
                return headA;
            }
            if (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                }
                set.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }

    /**
     * 双指针法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode la = headA;
        ListNode lb = headB;
        if (la == null || lb == null) {
            return null;
        }
        while (la != lb) {
            if (la == null) {
                la = headB;
            } else {
                la = la.next;
            }

            if (lb == null) {
                lb = headA;
            } else {
                lb = lb.next;
            }
        }
        return la;
    }
}
