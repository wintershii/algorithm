package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combine_77 {

    private boolean[] book;

    public static void main(String[] args) {
        System.out.println(new Combine_77().combine(4,2));
    }


    public List<List<Integer>> combine(int n, int k) {
        book = new boolean[n+1];
        List<List<Integer>> list = new ArrayList<>();
        dfs(list,n,k,0,new ArrayList<>());
        return list;
    }

    public void dfs(List<List<Integer>> list, int n, int k, int now, List<Integer> tmp) {
        if (now == k) {
            List<Integer> ok = new ArrayList<>(tmp);
            list.add(ok);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (book[i]) {
                return;
            }
            book[i] = true;
            tmp.add(i);
            dfs(list,n,k,now+1,tmp);
            tmp.remove((Object)i);
            book[i] = false;
        }

    }
}
