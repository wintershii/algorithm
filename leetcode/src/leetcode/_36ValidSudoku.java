package leetcode;

public class _36ValidSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        //遍历整张表
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    //此处放的数字
                    int num = board[i][j] - '1';
                    //所在的block块
                    int blockIndex = i / 3 * 3 + j / 3;
                    //若已经在该行,列或块出现该数字,直接返回失败
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        //标记
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
