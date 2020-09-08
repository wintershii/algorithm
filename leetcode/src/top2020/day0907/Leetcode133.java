package top2020.day0907;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 克隆图
 * 思路，一个map来存储，key为克隆前，value为克隆后
 * 若map中存在，则直接get并放置。否则new并进行拷贝
 */
public class Leetcode133 {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }
            Map<Node, Node> map = new HashMap<>();
            Node res = new Node();
            map.put(node, res);
            clone(map, node, res);
            return res;
        }

        private void clone(Map<Node, Node> map, Node node, Node res) {
            res.val = node.val;
            for (Node n : node.neighbors) {
                if (map.containsKey(n)) {
                    res.neighbors.add(map.get(n));
                } else {
                    Node tmp = new Node();
                    map.put(n, tmp);
                    clone(map, n, tmp);
                    res.neighbors.add(tmp);
                }
            }
        }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}