package top2020.day0907;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * LRUCache
 * 不使用linkedhashmap
 * 使用map+linkedlist
 */
public class Leetcode146 {

    Map<Integer, Integer> map;
    Queue<Integer> queue;
    int capacity;

    public Leetcode146(int capacity) {
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
        } else if (map.size() == capacity) {
            map.remove(queue.poll());
            queue.add(key);
            map.put(key, value);
        } else {
            queue.add(key);
            map.put(key, value);
        }
    }
}
