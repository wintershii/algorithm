package leetcode;

public class _73SetZeroes {

    /**
     * 置零
     * 思路 : 首先扫描第一行和第一列有没有为0的值,分别用两个布尔值标记
     * 然后从下标 1,1 开始扫描, 如果某个位置是0 则将其对应的第一行和第一列(即 i,0位置和 0,j位置 置为0)
     * 然后顺序扫描第一行和第一列, 如果有那个位置为0, 则将该行或该列全部归0
     * 最后根据开始时得到的两布尔值, 将第一行和第一列置0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean row = false, col = false;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                col = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                row = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][0] = 0;
            }
        }


    }
}
