import java.util.Scanner;

public class Prac {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int l = scan.nextInt();
        boolean flag = false;
        for (int i = l; i <= 100; ++i) {
            if ((2 * n + i - i * i) % (2 * i) == 0) {
                flag = true;
                int a1 = (2 * n + i - i * i) / (2 * i);
                for (int j = 0; j < i - 1; ++j) {
                    int tmp = a1 + j;
                    System.out.print(tmp + " ");
                }
                System.out.println(a1 + i - 1);
                break;
            }
        }
        if (!flag) {
            System.out.println("No");
        }
    }

    //爬楼梯
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int x = 1;
        int y = 2;
        for (int i = 0; i < n-2; i++) {
            int tmp = x + y;
            x = y;
            y = tmp;
        }
        return y;
    }

    //编辑距离
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }
}
