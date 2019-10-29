package leetcode;

/**
 * 二进制1的个数
 */
public class _191HammingWeight {
    public int hammingWeight(int n) {

        int res = 0;
        int len = Integer.toBinaryString(n).length();
        while (len-- > 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
