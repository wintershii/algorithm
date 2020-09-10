package top2020.day0910;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 */
public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (char c : p.toCharArray()) {
            pArr[c-'a']++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (i >= p.length()) {
                sArr[s.charAt(i-p.length()) - 'a']--;
            }
            sArr[s.charAt(i) - 'a']++;
            if (Arrays.equals(sArr, pArr)) {
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
}
