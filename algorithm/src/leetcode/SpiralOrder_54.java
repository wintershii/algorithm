package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder_54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(new SpiralOrder_54().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int count = 0;
        for (int i = 0; i <= Math.min(row,col) / 2 && count < row * col; i++) {
            int rowEnd = col - i;
            int colEnd = row - i;
            for (int j = i; j < rowEnd && count < row * col; j++) {
                list.add(matrix[i][j]);
                count++;
            }
            for (int j = i+1; j < colEnd && count < row * col; j++) {
                list.add(matrix[j][rowEnd-1]);
                count++;
            }
            for (int j = rowEnd-2; j >= i && count < row * col; j--) {
                list.add(matrix[colEnd-1][j]);
                count++;
            }
            for (int j = colEnd-2; j > i && count < row * col; j--) {
                list.add(matrix[j][i]);
                count++;
            }
        }
        return list;
    }
}
