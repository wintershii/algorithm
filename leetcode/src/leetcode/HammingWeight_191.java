package leetcode;

import java.util.HashMap;

public class HammingWeight_191 {
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
