package microsoft;

public class TicTacToe {

    int[][] board;
    int cap;

    public TicTacToe(int n) {
        board = new int[n][n];
        cap = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        return check(row,col,player);
    }

    private int check(int row, int col, int player) {
        int res = player;
        if (row == col) {
            for (int i = 0; i < cap; ++i) {
                if (board[i][i] != player) {
                    res = 0;
                    break;
                }
            }
            if (res == player) {
                return player;
            }
        }
        res = player;
        if (row + col == cap - 1) {
            for (int i = 0; i < cap; ++i) {
                if (board[i][cap-i-1] != player) {
                    res = 0;
                    break;
                }
            }
            if (res == player) {
                return player;
            }
        }
        res = player;
        for (int i = 0; i < cap; ++i) {
            if (board[row][i] != player) {
                res = 0;
                break;
            }
        }
        if (res == player) {
            return player;
        }
        res = player;
        for (int i = 0; i < cap; ++i) {
            if (board[i][col] != player) {
                res = 0;
                break;
            }
        }
        return res;
    }
}
