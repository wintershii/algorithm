package classify._3dp;

/**
 * 二维数组从左上角到右下角的最短路径
 */
public class _7minPathSum {

    public static void main(String[] args) {
        System.out.println(new _7minPathSum().minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (i == 0) {
                    dp[0][j] = dp[0][j-1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][0] = dp[i-1][0] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }

            }
        }
        return dp[n-1][n-1];
    }
}
