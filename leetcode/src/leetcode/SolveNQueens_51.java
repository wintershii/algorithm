package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens_51 {
    public static void main(String[] args) {

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int arr[] = new int[n];
        putQueen(list,0,n,arr);
        return list;
    }


    private int count = 0;
    public int totalNQueens(int n) {
        int[] arr = new int[n];
        putQueen2(0,n,arr);
        return count;
    }



    public void putQueen2(int row, int n, int[] arr) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[row] = i;
            if (check(arr,row)) {
                putQueen2(row+1,n,arr);
            }
        }
    }


    public void putQueen(List<List<String>> list, int row, int n, int[] arr) {
        if (row == n) {
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (arr[i] == j) sb.append("Q");
                    else sb.append(".");
                }
                strings.add(sb.toString());
            }
            list.add(strings);
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[row] = i;
            if (check(arr,row)) {
                putQueen(list,row+1,n,arr);
            }
        }
    }

    public boolean check(int[] arr, int row) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row] || Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
