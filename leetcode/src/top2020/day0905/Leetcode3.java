package top2020.day0905;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复字符
 * 使用map做优化，但是必须加上判断map,get(s.charAt(j) >= i)
 */
public class Leetcode3 {
    public static void main(String[] args) {
        System.out.println(new Leetcode3().lengthOfLongestSubstring("abba"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) > i) {
                i = map.get(s.charAt(j)) + 1;
                map.remove(s.charAt(j));
            }
            map.put(s.charAt(j), j);
            System.out.println(s.charAt(j) + " " + j);
            j++;
            res = Math.max(res, j - i);
            System.out.println(res);
        }
        return res;
    }
}
