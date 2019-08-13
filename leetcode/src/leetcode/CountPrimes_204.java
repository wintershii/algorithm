package leetcode;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes_204 {

    public static void main(String[] args) {
        System.out.println(new CountPrimes_204().countPrimes(10));
    }

    public int countPrimes(int n) {
        int res = 0;
        for (int i = 1; i < n; ++i) {
            if (judge(i)) {
                res++;
                System.out.println(i);
            }

        }
        return res;
    }

    private boolean judge(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
        for (int i = 2; i <= num/2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
