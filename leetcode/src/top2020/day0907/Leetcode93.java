package top2020.day0907;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址
 * 搜索。根据.的个数分割
 * 每次搜索当前字符串前1-4的串，并转换为数字，过滤，并进行再次过滤
 */
public class Leetcode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, "", res);
        return res;
    }

    public void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) {
                res.add(out);
            }
            return;
        }
        for (int i = 1; i < 4; ++i) {
            if (s.length() < i) {
                break;
            }
            int val = Integer.parseInt(s.substring(0, i));
            //过滤掉大于255，以及错误格式的数字
            if (val > 255 || i != String.valueOf(val).length()) {
                continue;
            }
            helper(s.substring(i), n+1, out+s.substring(0,i) + (n == 3 ? "" : "."), res);
        }
    }
}
