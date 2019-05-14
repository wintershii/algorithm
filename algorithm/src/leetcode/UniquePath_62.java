package leetcode;

public class UniquePath_62 {
    private int res = 0;
    private int[][] dir = new int[][]{{0,1},{1,0}};
    public static void main(String[] args) {
        System.out.println(new UniquePath_62().uniquePaths(7,3));
    }



    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 暴力搜索超时
     * @param m
     * @param n
     * @return
     */
    public int violence(int m, int n) {
        boolean[][] book = new boolean[m][n];
        book[0][0] = true;
        dfs(book,m,n,0,0);
        return res;
    }

    private void dfs(boolean[][] book, int m, int n, int x, int y) {
        if (x == m-1 && y == n-1) {
            res++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            int tx = x + dir[i][0];
            int ty = y + dir[i][1];
            if (tx > m-1 || ty > n-1 || book[tx][ty]) {
                continue;
            }
            book[tx][ty] = true;
            dfs(book,m,n,tx,ty);
            book[tx][ty] = false;
        }
    }
}
