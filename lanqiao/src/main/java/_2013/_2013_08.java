package _2013;

import java.util.Scanner;

/**
 * 幸运数
 *
 * 1 2 3 4 5 6 ...
 * 1 是第一个幸运数
 * 从2 开始,把所有序号能被 2 整除的项删除, 变成 1 _ 3 _ 5 _ 7 _ 9 ...
 * 这时,3为第二个幸运数,然后把所有能被3整除的序号位置的数删去
 * 1 3 7 9 13 ...7 为第三个
 */
public class _2013_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m,n;
        m = scan.nextInt();
        n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 2 * i + 1;
        }
        //初始化就把2的倍数删除了
        int l = 1;//幸运数的下标,a[l]是幸运数
        while (a[l] < n) {
            int p = l+1;//数字向前挪动的坑位
            for (int i = l+1; i < n; i++) {
                if ((i+1) % a[l] == 0) {

                } else {
                    a[p] = a[i];
                    p++;
                }
            }
            l++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= n) break;
            if (a[i] > m) ans++;
        }
        System.out.println(ans);
    }
}

