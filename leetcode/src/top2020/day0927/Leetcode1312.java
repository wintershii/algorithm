package top2020.day0927;

public class Leetcode1312 {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >=0; --i) {
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
