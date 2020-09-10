package top2020.day0909;

/**
 * 回文子串
 *
 */
public class Leetcode647 {
    int res = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); ++i) {
            count(s, i, i);
            count(s, i, i+1);
        }
        return res;
    }

    public void count(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            res++;
        }
    }
}
