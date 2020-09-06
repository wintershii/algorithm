package top2020.day0906;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 * 一个arr，下标表示第几行，值表示第几列
 * 当arr[i] == j时表示该位置有皇后
 * check方法检测是否可以在当前位置放置皇后，以判断是否继续搜索
 */
public class Leetcode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] arr = new int[n];
        putQueen(res, 0, n, arr);
        return res;
    }

    public void putQueen(List<List<String>> res, int index, int n, int[] arr) {
        if (index == n) {
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; ++j) {
                    if (arr[i] == j) sb.append("Q");
                    else sb.append(".");
                }
                strings.add(sb.toString());
            }
            res.add(strings);
            return;
        }
        for (int i = 0; i < n; ++i) {
            arr[index] = i;
            if (check(arr, index)) {
                putQueen(res, index+1, n, arr);
            }
        }
    }

    private boolean check(int[] arr, int index) {
        for (int i = 0; i < index; ++i) {
            if (arr[i] == arr[index] || Math.abs(i - index) == Math.abs(arr[i] - arr[index])) {
                return false;
            }
        }
        return true;
    }
}
