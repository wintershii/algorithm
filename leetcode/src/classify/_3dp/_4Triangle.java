package classify._3dp;

/**
 * 走三角形
 * 二维数组, 保存了一个三角形, 求从三角形顶端到底端各数字和最小的路径之和
 * 每次可以向下走相邻两个位置
 */
public class _4Triangle {


    public static void main(String[] args) {
        System.out.println(new _4Triangle().minimumTotal(new int[][]{
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        }));
    }

    /**
     * 状态转移方程 : classify._3dp[i][j] = num[i][j] + MIN(classify._3dp[i+1][j],classify._3dp[i+1][j+1])
     * @param triangle
     * @return
     */
    public int minimumTotal(int[][] triangle) {
        int m = triangle.length;
        int[][] dp = new int[m][m];
        for (int i = 0; i < triangle[m-1].length; ++i) {
            dp[m-1][i] = triangle[m-1][i];
        }
        for (int i = m - 2; i >= 0; --i) {
            for (int j = 0;j < triangle[i].length; ++j) {
                dp[i][j] = triangle[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
