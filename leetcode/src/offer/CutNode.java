package offer;

/**
 * 剪绳子
 * 长度为n的绳子,剪成m段, 求最优解使得每段乘积最大
 */
public class CutNode {

    public static void main(String[] args) {
        //System.out.println(new CutNode().cutDp(8));
        System.out.println(new CutNode().cutGreedy(8));
    }

    /**
     * 动态规划解题
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     * 状态转移方程
     * f(n) = MAX(i*f(n-i))
     * @param length
     * @return
     */
    public int cutDp(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] dp = new int[length+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; ++i) {
            max = 0;
            for (int j = 1; j <= i/2; ++j) {
                int tmp = dp[j] * dp[i-j];
                if (tmp > max) {
                    max = tmp;
                }
            }
            dp[i] = max;
        }
        return dp[length];
    }

    /**
     * 贪心算法
     * O(1)的时间和空间
     * 思想: 能分成3就分成3, 除非有4
     * @param length
     * @return
     */
    public int cutGreedy(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int timeOfThree = length / 3;
        if (length - timeOfThree * 3 == 1) {
            timeOfThree -= 1;
        }
        int timeOfTwo = ((length - timeOfThree * 3) / 2);
        return (int) (Math.pow(3,timeOfThree) * Math.pow(2,timeOfTwo));
    }

}

