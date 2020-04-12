package a;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().getPowerFactor(39,1));
    }

    List<Integer> res;
    public int[] getPowerFactor(int R, int N) {
        if (N < 2) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int num = (int) (Math.log(R) / Math.log(N));

        dfs(R, N, 0, list, 0, num);

        if (res == null) {
            return null;
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
    private void dfs(int R, int N, int now, List<Integer> list, int sum, int num) {
        if (now > num) {
            if (sum == R) {
                res = new ArrayList<>(list);
                return;
            }
            return;
        }
        List<Integer> newList = new ArrayList<>(list);

        dfs(R,N,now+1,list,sum,num);

        newList.add(now);
        sum += Math.pow(N,now);
        dfs(R,N,now+1,newList,sum,num);
    }
}
