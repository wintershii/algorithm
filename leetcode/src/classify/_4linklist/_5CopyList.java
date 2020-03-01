package classify._4linklist;

/**
 * 随机指针的复杂链表的拷贝
 */
public class _5CopyList {
    /**
     * 将每个节点都复制一份放在原节点的后面
     * 然后通过改变random指针的指向
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode node = head;
        while (node != null) {
            RandomListNode clone = new RandomListNode(node.label,node.next,null);
            node.next = clone;
            node = clone.next;
        }
        node = head;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        node = head;
        RandomListNode res = head.next;
        while (node.next != null) {
            RandomListNode tmp = node.next;
            node.next = node.next.next;
            node = tmp;
        }
        return res;
    }
}


class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int label, RandomListNode next, RandomListNode random) {
        this.label = label;
        this.next = next;
        this.random = random;
    }
}