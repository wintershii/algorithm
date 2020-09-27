package ms325;

/**
 * 给一个字符串，每次可以移除其中一个字符，或者移除一个回文子串，求 全部移除所需最少次数
 *
 */
public class NoTwo {
    public static void main(String[] args) {
        System.out.println(new NoTwo().minRemoves(new int[]{1,4,3,1,5}));
    }

    public int minRemoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for (int l = 1; l <= n; ++l) {
            int i = 0, j = l - 1;
            while (j < n) {
                if (l == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 1 + dp[i+1][j];
                    for (int k = i + 1; k <= j; ++k) {
                        if (arr[i] == arr[k]) {
                            dp[i][j] = Math.min(dp[i][j], dp[i+1][k-1] + dp[k+1][j] + (i+1 == k ? 1 : 0));
                        }
                    }
                }
                i++;
                j++;
            }
        }
        return dp[0][n-1];
    }
}
