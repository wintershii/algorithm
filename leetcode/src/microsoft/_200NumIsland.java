package microsoft;

public class _200NumIsland {

    private int res = 0;
    private boolean[][] book = null;
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        System.out.println(new _200NumIsland().numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        book = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && !book[i][j]) {
                    dfs(grid, i, j, book);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] book) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || book[i][j] || grid[i][j] == '0') {
            return;
        }
        book[i][j] = true;
        for (int k = 0; k < 4; ++k) {
            int i2 = i + dir[k][0];
            int j2 = j + dir[k][1];
            dfs(grid, i2, j2, book);
        }
    }
}
