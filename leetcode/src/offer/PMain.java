package offer;

import java.util.Scanner;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class PMain {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        int[] egg = new int[n];
        for (int i = 0; i < n; ++i) {
            egg[i] = scan.nextInt();
        }
        for (int i = 0; i < m; ++i) {
            int max = 0;
            int mv = Integer.MIN_VALUE;
            for (int j = 0; j < n; ++j) {
                if (egg[j] > mv) {
                    max = j;
                    mv = egg[j];
                }
                egg[j] += k;

            }

            egg[max] /= 2;
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += egg[i];
        }
        System.out.println(res);
    }
}
