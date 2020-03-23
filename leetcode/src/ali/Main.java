package ali;

import java.util.Scanner;

public class Main {


    /**
     * 思路：找到通项公式： sum = 2 * 2^(n-1)
     * 然后用快速幂
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println((n * fastPower(2,(int)(Math.pow(10,9) + 7),n-1)) % (int)(Math.pow(10,9) + 7));
    }

    public static long fastPower(int a, int b, int n) {
        if (n == 0) {
            return 1 % b;
        }
        long ans = 1l;
        long base = a % b;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = (ans * base) % b;
            }
            //为了避免超出long的范围，所以取三次模
            base = (base % b) * (base % b) % b;
            n >>= 1;
        }
        return ans;
    }

//    /**
//     * 暴力，过不了
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        n %= (Math.pow(10,9)+7);
//        long sum = 0;
//        for (int i = 1; i <= n; ++i) {
//            sum += count(n,i) * i;
//            sum %= (long)(Math.pow(10,9)+7);
//        }
//        System.out.println(sum%(long)(Math.pow(10,9)+7));
//    }

    public static long count(long n, long num) {
        long sum = 1;
        for (int i = 0; i < num; ++i) {
            sum *= n;
            sum %= (long)(Math.pow(10,9) + 7);
            n--;
        }
        n = num;
        long sum2 =  1;
        for (int i = 0; i < num; ++i) {
            sum2 *= n;
            sum2 %= (long)(Math.pow(10,9) + 7);
            n--;
        }
        return sum / sum2;
    }

}
