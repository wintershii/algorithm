package _9hash;

import java.util.HashSet;

/**
 * 最长无重复字符子串
 */
public class _2LongestSonString {
    /**
     * 1.暴力枚举 O(n^3)
     * 2.滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < chars.length && j < chars.length) {
            if (!set.contains(chars[j])) {
                set.add(chars[j++]);
                res = Math.max(res,j - i);
            } else {
                set.remove(chars[i++]);
            }
        }
        return res;
    }
}
