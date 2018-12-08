package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目:恢复IP地址
 * 来源:leetcode字节跳动专栏
 *
 * 根据目前刷了这么多题，得出了两个经验:
 * 一是只要遇到字符串的子序列或配准问题首先考虑动态规划DP,二是只要遇到需要求出所有可能情况首先考虑用递归
 */
public class RecoverTheIpAddress {
    public static void main(String[] args) {
        System.out.println(new RecoverTheIpAddress().restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s,0,"",res);
        return res;
    }

    public void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) {
                res.add(out);
            }
            return;
        }

        for (int k = 1; k < 4; k++) {
            if (s.length() < k) {
                break;
            }
            int val = Integer.parseInt(s.substring(0,k));
            //如果比255大,或者出现01 这种类似的写法,排除
            if (val > 255 || k != String.valueOf(val).length()) {
                continue;
            }
            //递归部分
            //将s剩余部分,n+1,若已经结束不加".",
            helper(s.substring(k),n+1,out + s.substring(0,k) + (n == 3 ? "" : "."), res);
        }
    }
}
