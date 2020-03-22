import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String mn = scan.nextLine();
        int n = Integer.parseInt(mn.split(" ")[0]);
        int m = Integer.parseInt(mn.split(" ")[1]);
        String nums = scan.nextLine();
        int[] arr = new int[nums.length()];
        for (int i = 0; i < nums.length(); ++i) {
            arr[i] = nums.charAt(i) - '0';
        }

        for (int i = 0; i < m; ++i) {
            String query = scan.nextLine();
            if (query.charAt(0) == 'q') {
                System.out.println(findLongest(arr));
            } else {
                String[] range = query.split(" ");
                int p = Integer.parseInt(range[1]);
                int q = Integer.parseInt(range[2]);
                for (int j = p - 1; j < q; ++j) {
                    arr[j] = arr[j] == 0 ? 1 : 0;
                }
            }
        }
    }

    private static int findLongest(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int[] dp = new int[arr.length+1];
        dp[0] = 0;
        dp[1] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 2; i <= arr.length; ++i) {
            for (int j = 1; j < i; ++j) {
                if (arr[i-1] >= arr[j-1] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            if (dp[i] > res) {
                res = dp[i];
            }
        }

        return res;
    }
}
