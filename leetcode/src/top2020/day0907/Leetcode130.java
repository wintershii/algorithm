package top2020.day0907;

/**
 * 被围绕的区域
 *思路：从四条边出发，遇到O就进行搜索，将不会被包围的O标记
 * 最后将没有标记到的O改成X
 */
public class Leetcode130 {
    public  void solve(char[][] board) {
        if (board.length == 0) return;
        int row = board.length, col = board[0].length;
        boolean[][] out = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') helper(board, out, 0, i);
            if (board[row - 1][i] == 'O') helper(board, out, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') helper(board, out, i, 0);
            if (board[i][col - 1] == 'O') helper(board, out, i, col - 1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!out[i][j]) board[i][j] = 'X';
            }
        }
    }

    public  void helper(char[][] board, boolean[][] out, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (out[i][j]) return;
            if (board[i][j] == 'O') {
                out[i][j] = true;
                helper(board, out, i - 1, j);
                helper(board, out, i + 1, j);
                helper(board, out, i, j - 1);
                helper(board, out, i, j + 1);
            }

        }
    }
}
