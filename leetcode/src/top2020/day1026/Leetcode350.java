package top2020.day1026;

import java.util.*;

public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums1) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        List<Integer> list = new ArrayList<>();
//        for (int num : nums2) {
//            int cnt = map.getOrDefault(num, 0);
//            if (cnt > 0) {
//                list.add(num);
//                map.put(num, map.getOrDefault(num, 0) - 1);
//            }
//        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); ++i) {
//            res[i] = list.get(i);
//        }
//        return res;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); ++k) {
            res[k] = list.get(k);
        }
        return res;
    }
}
