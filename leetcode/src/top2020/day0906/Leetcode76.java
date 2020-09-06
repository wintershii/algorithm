package top2020.day0906;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * 双map+计数器判断是否满足条件
 * 滑动窗口
 */
public class Leetcode76 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        if (s.contains(t)) {
            return t;
        }
        Map<Character, Integer> stand = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            stand.put(t.charAt(i), stand.getOrDefault(t.charAt(i), 0));
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int formed = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        while (j < s.length()) {
            if (stand.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0));
            }
            if (stand.containsKey(s.charAt(j)) && stand.get(s.charAt(j)).intValue() == map.get(s.charAt(j)).intValue()) {
                formed++;
            }
            while (i <= j && formed == stand.size()) {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    res = s.substring(i, j+1);
                }
                if (stand.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                }
                if (stand.containsKey(s.charAt(i)) && map.get(s.charAt(i)) < stand.get(s.charAt(i))) {
                    formed--;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
