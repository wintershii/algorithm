package leetcode;

public class _79ExistWord {

    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] book;
    boolean flag;

    public static void main(String[] args) {

        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};

        System.out.println(new _79ExistWord().exist(board,"AAB"));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        book = new boolean[m][n];
        char[] words = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == words[0]) {
                    setBook(m,n);
                    book[i][j] = true;
                    dfs(board,words,i,j,m,n,book,0);
                }
            }
        }
        return flag;
    }

    public void dfs(char[][] board, char[] words, int x, int y, int m, int n, boolean[][] book, int now) {
        if (board[x][y] == words[now]) {
            now++;
            if (now == words.length) {
                flag = true;
                return;
            }
        } else {
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (flag) {
                return;
            }
            int tx = x + dir[i][0];
            int ty = y + dir[i][1];
            if (tx < 0 || tx > m-1 || ty < 0 || ty > n-1 || book[tx][ty]) {
                continue;
            }
            book[tx][ty] = true;
            dfs(board,words,tx,ty,m,n,book,now);
            book[tx][ty] = false;
        }

    }


    public void setBook(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                book[i][j] = false;
            }
        }
    }
}
