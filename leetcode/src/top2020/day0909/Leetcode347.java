package top2020.day0909;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前K个高频元素
 * Map+小顶堆
 */
public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int key : map.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else {
                if (map.get(key) > map.get(heap.peek())) {
                    heap.poll();
                    heap.add(key);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = heap.poll();
        }
        return res;
    }
}
