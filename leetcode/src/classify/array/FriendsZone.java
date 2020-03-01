package classify.array;

/**
 * 题目:朋友圈
 * 解决:DFS搜索图
 * 来源:leetcode字节跳动专栏
 */
public class FriendsZone {
    public static void main(String[] args) {
        int[][] map = new int[][]{  {1,1,0},
                                    {1,1,1},
                                    {0,1,1}};
        System.out.println(findCircleNum(map));
    }

    /**
     * 通过DFS搜索,
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        //遍历每一个人,每一行代表一个人
        for (int i = 0; i < n; i++) {
            //若朋友圈人数大于0,则朋友圈总数加一
            if (dfs(M,i,visited) > 0) {
                count++;
            }
        }
        return count;
    }

    public static int dfs(int[][] M, int i, boolean[] visited) {
        //判断此人是否已经在另一个朋友圈了
        if (visited[i]) {
            return 0;
        }
        //标记此人已经访问
        visited[i] = true;


        int count = 1;
        for (int j = 0; j < visited.length; j++) {
            //遍历此人与其他人的关系,如果是一个朋友圈,继续搜索他的朋友并标记
            if (i != j && M[i][j] == 1) {
                count += dfs(M,j,visited);
            }
        }
        return count;
    }
}
