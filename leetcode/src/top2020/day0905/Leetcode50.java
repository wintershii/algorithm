package top2020.day0905;

/**
 * pow(x,n)
 * 快速幂
 */
public class Leetcode50 {
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1.0 / res : res;
    }
}
