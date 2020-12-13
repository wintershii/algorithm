package top2020.day1026;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode451 {
    public String frequencySort(String s) {
        //map + 大顶堆
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        PriorityQueue<Character> maxHeap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
//        maxHeap.addAll(map.keySet());
//        StringBuilder sb = new StringBuilder();
//        while (!maxHeap.isEmpty()) {
//            char c = maxHeap.poll();
//            int cnt = map.get(c);
//            for (int i = 0 ; i < cnt; ++i) {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
        if (s == null || s.length() == 0) {
            return s;
        }
        //int[] cnt = new int[128];
        MyType[] cnt = new MyType[128];
        for (int i = 0; i < 128; ++i) {
            cnt[i].c = (char) i;
        }
        for (char c : s.toCharArray()) {
            cnt[c].freq++;
        }
        Arrays.sort(cnt, (o1, o2) -> o1.freq - o2.freq);
        StringBuilder sb = new StringBuilder();
        for (int i = 127; i >= 0; ++i) {
            if (cnt[i].freq <= 0) {
                break;
            }
            for (int j = 0; j < cnt[i].freq; ++j) {
                sb.append(cnt[i].c);
            }
        }
        return sb.toString();
    }

    class MyType {
        char c;
        int freq;
    }
}
