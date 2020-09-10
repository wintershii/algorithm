package top2020.day0910;

/**
 * 移掉K位数字
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 */
public class Leetcode402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; ++i) {
            int idx = 0;
            for (int j = 1; j < sb.length() && sb.charAt(j) >= sb.charAt(j-1); ++j) {
                idx = j;
            }
            sb.deleteCharAt(idx);
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
        }
        return sb.toString();
    }
}
