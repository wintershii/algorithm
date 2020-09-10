package top2020.day0909;

/**
 * 等式方程的可满足行
 * 并查集
 */
public class Leetcode990 {
    public boolean equationsPossible(String[] equations) {
        int[] father = new int[26];
        for (int i = 0; i < 26; i++) {
            father[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(father, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(father, index1) == find(father, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] father, int index1, int index2) {
        father[find(father,index1)] = father[find(father, index2)];
    }

    public int find(int[] father, int index) {
        while (father[index] != index) {
            //路径压缩
            father[index] = father[father[index]];
            index = father[index];
        }
        return index;
    }
}
