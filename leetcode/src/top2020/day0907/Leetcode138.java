package top2020.day0907;

/**
 * 复制带随机指针的链表
 * 先在每一个节点后面new一个新的节点
 * 然后遍历一遍，填充拷贝的节点的random
 * 最后分开
 */
public class Leetcode138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node node = head;
        while (node != null) {
            Node clone = new Node(node.val, node.next, null);
            Node tmp = node.next;
            node.next = clone;
            node = tmp;
        }
        node = head;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        node = head;
        Node res = head.next;
        while (node.next != null) {
            Node tmp = node.next;
            node.next = node.next.next;
            node = tmp;
        }
        return res;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}

