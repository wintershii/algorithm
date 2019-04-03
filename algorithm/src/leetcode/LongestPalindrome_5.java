package leetcode;

import java.util.Arrays;

public class LongestPalindrome_5 {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome_5().chaoMethod("a"));
    }


    /**
     * 自己写的暴力解法，枚举所有子串，依次判定(92/103)
     * 加上了动态规划,当出现一个子串是回文时,继续判断其两头是不是回文串(94/103),貌似没有什么卵用...
     *
     * @param s
     * @return
     */
    public String mySolve(String s) {
        String ans = "";
        int len = s.length();
        boolean[][] book = new boolean[len][len+1];
        for (int i = 0; i < len; ++i) {
            for (int j = i+1; j <= len; ++j) {
                String tmp = s.substring(i,j);
                if (!book[i][j] && check(tmp)) {
                    book[i][j] = true;
                    if (j-i > ans.length()) {
                        ans = tmp;
                    }
                    int p = i-1;
                    int q = j+1;
                    while (p >= 0 && q < len && !book[p][q] && s.charAt(p) == s.charAt(q-1)) {
                        if (q - p > ans.length()) {
                            ans = s.substring(p,q);
                        }
                        book[p][q] = true;
                        --p;
                        ++q;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 超哥的解法
     * @param s
     * @return
     */
    public String chaoMethod(String s) {
        int result = 0;
        String ans = "";
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i+result; j <  s.length(); ++j) {
                String tmp = s.substring(i,j+1);
                if (check(tmp) && tmp.length() > result) {
                    result = tmp.length();
                    ans = tmp;
                }
            }
        }
        return ans;
    }


    /**
     * 检查字符串是否是回文串
     * @param s
     * @return
     */
    public boolean check(String s) {
        int len = s.length();
        for (int i = 0; i < len/2; ++i) {
            if (s.charAt(i) != s.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }
}
