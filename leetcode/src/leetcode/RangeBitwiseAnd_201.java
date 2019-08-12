package leetcode;

public class RangeBitwiseAnd_201 {

    /**
     * 方案一 : 寻找公共前缀
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        for (; m != n; ++offset) {
            m >>= 1;
            n >>= 1;
        }
        return n << offset;
    }

    /**
     * 方案而, 从高位向低位与
     */
    public int solution(int m, int n) {
        while (n > m) {
            n &= (n-1);
        }
        return n;
    }

}
