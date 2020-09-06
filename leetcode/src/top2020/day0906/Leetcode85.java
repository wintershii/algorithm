package top2020.day0906;

/**
 * 最大矩形
 * 动态规划思想，三维数组
 * 第三维中0代表当前位置向左最大的宽度
 * 1代表当前位置向上最大的高度
 *
 * 第一行和第一列特殊处理
 * dp[i][j][0] = dp[i][j-1][0] + 1
 * dp[i][j][1] = dp[i-1][j][1] + 1
 */
public class Leetcode85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][][] dp = new int[m][n][2];
        int max = 0;
        if (matrix[0][0] == '1') {
            dp[0][0][0] = 1;
            dp[0][0][1] = 1;
            max = 1;
        }
        for (int i = 1; i < m; ++i) {
            if (matrix[i][0] == '1') {
                dp[i][0][0] = 1;
                dp[i][0][1] = dp[i-1][0][1] + 1;
                max = Math.max(max, dp[i][0][1]);
            }
        }
        for (int i = 1; i < n; ++i) {
            if (matrix[0][i] == '1') {
                dp[0][i][0] = dp[0][i-1][0] + 1;
                dp[0][i][1] = 1;
                max = Math.max(max, dp[0][i][0]);
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i][j][0] = dp[i][j-1][0] + 1;
                    dp[i][j][1] = dp[i-1][j][1] + 1;
                    int minHeight = dp[i][j][1];
                    int width = dp[i][j][0];
                    for (int k = 1; k <= width; ++k) {
                        minHeight = Math.min(minHeight, dp[i][j-k+1][1]);
                        max = Math.max(max, k * minHeight);
                    }
                }
            }
        }
        return max;
    }
}
