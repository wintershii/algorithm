package a;

import java.util.ArrayList;
import java.util.List;

public class YangLiuying {

    public static void main(String[] args) {
        // 邻接矩阵
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 0},
                {1, 1, 0, 0}
        };
        List<List<Integer>> res = solve(matrix);
        System.out.println(res);
        System.out.println(res.size());
    }

    private static List<List<Integer>> solve(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[matrix.length];
        List<List<Integer>> res = new ArrayList<>();
        helper(matrix, 0, visited, list, res);
        return res;
    }

    private static void helper(int[][] matrix, int level,
                               boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (matrix.length == level) {
            int last = list.get(list.size() - 1);
            int first = list.get(0);
            if (matrix[last][first] == 1) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < matrix.length; ++i) {
            if (!visited[i]) {
                if (list.size() > 0) {
                    int last = list.get(list.size() - 1);
                    if (matrix[last][i] != 1) {
                        continue;
                    }
                }
                visited[i] = true;
                list.add(i);
                helper(matrix, level+1, visited, list, res);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

    }

//    private static List<Integer> solve(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return null;
//        }
//        List<Integer> list = new ArrayList<>();
//        boolean[] visited = new boolean[matrix.length];
//        int initial = 0;
//        visited[initial] = true;
//        list.add(initial);
//        int count = 1;
//        int tmp = initial;
//        while (true) {
//            boolean flag = false;
//            for (int i = 0; i < matrix.length; ++i) {
//                if (matrix[tmp][i] == 1 && !visited[i]) {
//                    visited[i] = true;
//                    list.add(i);
//                    tmp = i;
//                    count++;
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//                break;
//            }
//            if (count == matrix.length) {
//                if (matrix[tmp][initial] == 1) {
//                    return list;
//                } else {
//                    return null;
//                }
//            }
//        }
//        return list;
//    }



}
