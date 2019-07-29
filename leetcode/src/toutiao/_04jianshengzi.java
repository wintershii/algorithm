package toutiao;

import java.util.Scanner;

public class _04jianshengzi {

    static int max = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n,m;
        //原始绳子个数
        n = scan.nextInt();
        //最终需要绳子个数
        m = scan.nextInt();

        int[] li = new int[n];
        for (int i = 0; i < n; i++) {
            li[i] = scan.nextInt();
            if (max < li[i]) {
                max = li[i];
            }
        }

        System.out.printf("%.2f",count(n,m,li));

    }

    public static double count(int n, int m, int[] li) {
        double small = 0, big = 2 * max;
        for (int i = 0; i < 100; i++) {
            double mid = (small + big) / 2;
            int ans = 0;
            for (int j = 0; j < n; j++) {
                ans += (li[j]/mid);
            }

            if (ans < m) {
                big = mid;
            } else {
                small = mid;
            }
        }
        return big;
    }

}
