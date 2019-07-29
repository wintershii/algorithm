package leetcode;

import java.util.Scanner;

public class GenerateMatrix2_59 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] matrix = new GenerateMatrix2_59().generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 0;
        for (int i = 0; i <= n/2; i++) {
            int end = n - i;
            for (int j = i; j < end && count < n*n; j++)
                matrix[i][j] = ++count;
            for (int j = i + 1; j < end && count < n*n; j++)
                matrix[j][end-1] = ++count;
            for (int j = end-2; j >= i && count < n*n; j--)
                matrix[end-1][j] = ++count;
            for (int j = end-2; j > i && count < n*n; j--)
                matrix[j][i] = ++count;
        }
        return matrix;
    }
}
