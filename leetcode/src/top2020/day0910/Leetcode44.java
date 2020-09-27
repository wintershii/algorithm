package top2020.day0910;

/**
 * 通配符匹配
 */
public class Leetcode44 {
    public static void main(String[] args) {
        System.out.println(new Leetcode44().isMatch("mississippi","m??*ss*?i*pi"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if(p.charAt(j-1) == '*') dp[0][j] = true;
            else break;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else if (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <=n; ++j) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];
    }
}
