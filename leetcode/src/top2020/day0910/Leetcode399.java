package top2020.day0910;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 除法求值
 * 构造二维图+floyd算法
 *
 */
public class Leetcode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (List<String> list : equations) {
            for (String str : list) {
                if (!map.containsKey(str)) {
                    map.put(str, count++);
                }
            }
        }
        double[][] matrix = new double[count][count];
        for (String s : map.keySet()) {
            int index = map.get(s);
            matrix[index][index] = 1.0;
        }
        int index = 0;
        for (List<String> list : equations) {
            int a = map.get(list.get(0));
            int b = map.get(list.get(1));
            matrix[a][b] = values[index];
            matrix[b][a] = 1 / values[index++];
        }

        for (int i = 0; i < count; ++i) {
            for (int j = 0; j < count; ++j) {
                for (int k = 0; k < count; ++k) {
                    if (j == k || matrix[j][k] != 0) continue;
                    if (matrix[j][i] != 0 && matrix[i][k] != 0) {
                        matrix[j][k] = matrix[j][i] * matrix[i][k];
                    }
                }
            }
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; ++i) {
            List<String> q = queries.get(i);
            String a = q.get(0);
            String b = q.get(1);
            if (map.containsKey(a) && map.containsKey(b)) {
                int aa = map.get(a);
                int bb = map.get(b);
                double ans = matrix[aa][bb];
                res[i] = ans == 0 ? -1.0 : ans;
            } else {
                res[i] = -1.0;
            }
        }
        return res;
    }
}
