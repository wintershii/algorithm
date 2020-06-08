package p06;

/**
 * 并查集题目
 * 建立一个parent数组来存储连通分量信息
 * 数据具有传递性
 * x -> parent[x]代表父节点
 * 最终根节点相同的节点属于一个连通分量
 */
public class EquationsPossible_990 {

    public static void main(String[] args) {
        System.out.println(new EquationsPossible_990().equationsPossible(new String[]{"a==b","a!=b"}));
    }

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (int i = 0; i < equations.length; ++i) {
            if (equations[i].charAt(1) == '=') {
                unionFind.union(equations[i].charAt(0) - 'a',equations[i].charAt(3) - 'a');
            }
        }

        for (int i = 0; i < equations.length; ++i) {
            if (equations[i].charAt(1) == '!') {
                if (unionFind.isConnected(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }


    private class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
