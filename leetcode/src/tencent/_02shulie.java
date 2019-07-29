package tencent;

import java.util.Scanner;

public class _02shulie {
    public static void main(String[] args) {
        long q;
        long l,r;
        Scanner scan = new Scanner(System.in);
        q = scan.nextLong();

        while(q-- != 0) {
            l = scan.nextLong();
            r = scan.nextLong();
            if (l % 2 == 0 && r % 2 == 0) {
                long ans = (r-l)/2;
                System.out.println(l + ans);
            } else if (l % 2 != 0 && r % 2 != 0) {
                long ans = -((r-l)/2);
                System.out.println(-l + ans);
            } else if (l % 2 == 0 && r % 2 != 0) {
                long ans = (r-l+1)/2;
                System.out.println(-ans);
            } else {
                long ans = (r-l+1)/2;
                System.out.println(ans);
            }
        }
    }
}
