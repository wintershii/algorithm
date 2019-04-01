package _2017;

import java.util.Scanner;

/**
 * 分巧克力
 */
public class _2017_09 {
    static int n,k;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
        solve(arr,n);
        System.out.println(ans);
    }

    private static void solve(int[][] arr, int n) {
        int r = 10001;
        int l = 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += (arr[i][0]/mid) * (arr[i][1]/mid);
            }
            if (count >= k) {
                l = mid+1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
    }
}
