package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            list.add(i ^ i >> 1);
        }
        return list;
    }
}
