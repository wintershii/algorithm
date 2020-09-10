package top2020.day0909;

import java.util.HashSet;
import java.util.Set;

/**
 * 朋友圈
 * 并查集
 *
 */
public class LeetCode547 {
    public int findCircleNum(int[][] M) {
        int[] father = new int[M.length];
        for (int i = 0 ; i < father.length; ++i) {
            father[i] = i;
        }
        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M[0].length; ++j) {
                if (i != j) {
                    if (M[i][j] == 1) {
                        union(father, i, j);
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < father.length; ++i) {
            if (father[i] == i) {
                res++;
            }
        }
        return res;
    }

    public void union(int[] father, int index1, int index2) {
        father[find(father, index1)] = father[find(father, index2)];
    }

    public int find(int[] father, int index) {
        while (father[index] != index) {
            father[index] = father[father[index]];
            index = father[index];
        }
        return index;
    }
}
