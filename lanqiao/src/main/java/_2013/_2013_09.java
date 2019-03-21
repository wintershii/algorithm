package _2013;

import java.util.Scanner;

/**
 * 带分数
 *
 * 100可以表示为 : 3 +６９２５８／７１４
 * 也可以　１００　＝　８２　＋3546/197
 * 带分数中,1~9分别出现且只出现一次
 *
 * 100 有11种表示法
 */
public class _2013_09 {
    static int N;
    static int RES;
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        N = scann.nextInt();
        RES = 0;
        int[] arr = {1,2,3,4,5,6,7,8,9};
        f(arr,0);
        System.out.println(RES);
    }

    public static void f(int[] arr,int k) {
        if (k == arr.length) {
            check(arr);
            return;
        }

        for (int i = k; i < arr.length; i++) {
            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
            //继续深入搜索
            f(arr,k+1);

            //回溯
            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
        }
    }


    private static void check(int[] arr) {
        for (int i = 0; i <= 7; i++) {
            int num1 = toInt(arr,0,i);
            if (num1 > N) {
                continue;
            }
            for (int j = 1; j <= 8-i; j++) {
                int num2 = toInt(arr,i,j);
                int num3 = toInt(arr,i+j,9-i-j);
                if (num2%num3 == 0 && num1 + num2/num3 == N) {
                    RES++;
                }
            }

        }
    }

    private static int toInt(int[] arr, int start, int len) {
        int ans = 0;
        int l = 1;
        for (int i = start + len - 1; i >= start; i--) {
            ans += arr[i] * l;
            l *= 10;
        }
        return ans;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
