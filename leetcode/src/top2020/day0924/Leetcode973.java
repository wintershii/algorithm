package top2020.day0924;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode973 {
    public int[][] kClosest(int[][] points, int K) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            List<int[]> list = map.get(distance);
            if (list == null) {
                list = new ArrayList<>();
                map.put(distance, list);
            }
            list.add(point);
        }
        List<int[]> res = new ArrayList<>();
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            if (K <= 0) {
                break;
            }
            List<int[]> list = entry.getValue();
            K -= list.size();
            res.addAll(list);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
