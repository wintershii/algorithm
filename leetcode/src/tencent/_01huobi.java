package tencent;

import java.util.Scanner;

/**
 * 腾讯春招笔试第一题
 */
public class _01huobi {
    public static void main(String[] args) {
        long n,m;
        Scanner scan = new Scanner(System.in);
        n = scan.nextLong();
        m = scan.nextLong();
        System.out.println(getCount(n,m));
    }

    public static long getCount(long n, long price) {
        if (price % n == 0) {
            return price / n;
        }
        return price / n + 1;
    }

}
