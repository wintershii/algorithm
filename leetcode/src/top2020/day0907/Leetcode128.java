package top2020.day0907;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续序列
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            int left = map.getOrDefault(nums[i]-1, 0);
            int right = map.getOrDefault(nums[i]+1, 0);
            int len = left+right+1;
            if (map.containsKey(nums[i]-1)) {
                map.put(nums[i]-left, len);
            }
            if (map.containsKey(nums[i]+1)) {
                map.put(nums[i]+right, len);
            }
            map.put(nums[i], len);
            res = Math.max(res , len);
        }
        return res;
    }
}
