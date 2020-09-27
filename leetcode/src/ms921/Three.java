package ms921;

public class Three {
    public static void main(String[] args) {
        System.out.println(new Three().solve("JK"));
    }

    public int solve(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int l = 2; l <= dp.length; ++l) {
            int i = 0, j = l - 1;
            while (j < str.length()) {
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][k] + dp[k+1][j],
                            status(str.charAt(i), str.charAt(j)) + dp[i+1][j-1]);
                }
                i++;
                j++;
            }
        }
        return dp[0][str.length()-1];
    }

    private int status(char a, char b) {
        if (a == b) {
            return 1;
        } else if (a == 'J') {
            return 2;
        } else if (a == 'K') {
            return 0;
        }
        return 0;
    }
}
