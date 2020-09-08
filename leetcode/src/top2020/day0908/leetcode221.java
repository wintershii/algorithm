package top2020.day0908;

/**
 * 最大的正方形
 */
public class leetcode221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 0; i < matrix[0].length; ++i) {
            dp[0][i] = matrix[0][i] - '0';
        }
        int res = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i != 0 && j != 0) {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
