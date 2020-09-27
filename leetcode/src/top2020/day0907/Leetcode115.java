package top2020.day0907;

/**
 * 不同的子序列
 * 二维dp
 */
public class Leetcode115 {
    public static void main(String[] args) {
        System.out.println(new Leetcode115().numDistinct("rabbbit", "rabbit"));
    }
    public int numDistinct(String s, String t) {
        if (s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i <= s.length(); ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= t.length(); ++j) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
