package classify.array;

/**
 * 问题:岛屿的最大面积 解决:DFS
 * 来源:leetcode字节跳动专栏
 */
public class TheBigestAreaOfIsland {
    static int max = 0;
    static boolean visited[][] = new boolean[100][100];
    static int dir[][] = new int[][]{ {1,0},{0,1},{-1,0},{0,-1}};
    static int temp = 0;

    public static void main(String[] args) {

        int[][] grid = new int[][]{{ 1,1,0,1,1},
                                    {1,0,0,0,0},
                                    {0,0,0,0,1},
                                    {1,1,0,1,1}};

        dfsSolve(grid);
        System.out.println(max);
    }


    /**
     * 一个大神的写法,学习了学习了
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] != 0){
                    maxArea = Math.max(maxArea, areaOfIsland(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    public int areaOfIsland(int[][] grid, int i, int j){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 0){
            grid[i][j] = 0;
            return 1 + areaOfIsland(grid,i+1,j) + areaOfIsland(grid,i-1,j) + areaOfIsland(grid,i,j+1) + areaOfIsland(grid,i,j-1);
        }
        return 0;
    }




    /**\
     *  我的复杂DFS暴力解题法,用了类静态变量,所以提交代码出错
     * @param grid
     */
    public static void dfsSolve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                temp = 1;
                visited[i][j] = true;
                dfs(grid,i,j,m,n);
            }
        }
    }

    public static void dfs(int[][] grid, int x, int y, int m, int n) {
        if (x >= m && y >= n) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int tx = x + dir[i][0];
            int ty = y + dir[i][1];
            if (tx < 0 || ty < 0 || tx >= m || ty >= n) {
                return;
            }
            if (!visited[tx][ty] && grid[tx][ty] == 1) {
                visited[tx][ty] = true;
                temp++;
                if (temp > max) {
                    max = temp;
                }
                dfs(grid,tx,ty,m,n);
                //visited[tx][ty] = false;
            }
        }
    }
}
