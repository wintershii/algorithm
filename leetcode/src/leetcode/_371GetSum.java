package leetcode;

/**
 * 不使用+和-实现两整数相加
 * 使用位运算的思想
 */
public class _371GetSum {
    public int getSum(int a, int b) {
        if ((a & b) == 0) {
            return a | b;
        }
        return getSum((a ^ b), (a & b) << 1);
    }
}
