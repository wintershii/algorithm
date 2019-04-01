package _2017;

import java.util.Scanner;

/**]
 * k倍区间
 */
public class _2014_10 {
    static int n,k;
    static int sum;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        sum = 0;
        n = scan.nextInt();
        k = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        preAdd(arr);
        System.out.println(sum);
    }

    /**
     * 暴力枚举 不可取
     * @param arr
     */
    private static void violence(int[] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int ans = 0;
                for (int k = i; k <= j; k++) {
                    ans += arr[k];
                }
                if (ans % k == 0) {
                    sum++;
                }
            }
        }
    }

    /**
     * 前缀和  求和只需O（1）
     */
    private static void preAdd(int[] arr) {
        int[] s = new int[arr.length+1];
        s[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            s[i] = s[i - 1] + arr[i-1];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                int ans = s[j] - s[i];
                if (ans % k == 0 && ans != 0) {
                    sum++;
                }
            }
        }
    }
}
