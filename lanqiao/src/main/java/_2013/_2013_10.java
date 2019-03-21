package _2013;

import java.util.Scanner;

/**
 * 连号区间数
 *
 * 1~N的某个全排列中有多少个连号区间?
 * 连号区间: 如果区间[L,R] 里的所有元素 递增排序后能得到一个长度为 R-L+1的"连续数列",则这个区间叫做连号区间
 *
 * 输入:N  表示全排列的规模
 */
public class _2013_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

    }
}
