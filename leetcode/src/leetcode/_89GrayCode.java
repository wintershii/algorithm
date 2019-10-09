package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 * 位运算解决
 */
public class _89GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        //共有 2^n 个数字
        for (int i = 0; i < 1 << n; i++) {
            //使用位运算
            list.add(i ^ (i >> 1));
        }
        return list;
    }
}
