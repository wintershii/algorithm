package p05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayDivByK_974 {


    public static void main(String[] args) {
        System.out.println(new SubarrayDivByK_974().subarraysDivByK_1(new int[]{4,5,0,-2,-3,1},5));
    }


    public int subarraysDivByK_1(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for (int i : A) {
            sum += i;
            int mod = (sum % K + K) % K;
            int same = map.getOrDefault(mod,0);
            res += same;
            map.put(mod,same+1);
        }
        return res;
    }



    private int res = 0;




    public int subarraysDivByK(int[] A, int K) {
        boolean[] book = new boolean[A.length];
        List<Integer> list = new ArrayList<>();
        dfs(A, K, 0, book, list);
        return res;
    }

    public void dfs(int[] A, int K, int now, boolean[] book, List<Integer> list) {
        if (now == A.length) {
            if ((getSum(list) % K) == 0) {
                System.out.println(list);
                res++;
            }
            return;
        }
        if (!book[now]) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(A[now]);
            book[now] = true;
            dfs(A,K,now+1,book,newList);
            book[now] = false;
            dfs(A,K,now+1,book,list);
        }
    }

    private int getSum(List<Integer> list) {
        int cnt = 0;
        for (int i : list) {
            cnt += i;
        }
        return cnt;
    }
}
