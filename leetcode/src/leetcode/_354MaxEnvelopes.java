package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _354MaxEnvelopes {

    public static void main(String[] args) {
        System.out.println(new _354MaxEnvelopes().maxEnvelopes(new int[][]{{46,89},{50,53},{52,68},{72,45},{77,81}}));
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int m = envelopes.length;
        int[] dp = new int[m];
        for (int i = 0; i < m; ++i) {
            dp[i] = 1;
        }
        int res = 0;
        for (int i = 1; i < m; ++i) {
            int max = dp[i];
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    max = Math.max(max,dp[j]+1);
                }
            }
            dp[i] = max;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
