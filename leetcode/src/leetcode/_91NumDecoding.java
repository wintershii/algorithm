package leetcode;

/**
 * 解码方法
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _91NumDecoding {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0') return 0;
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            //其中一种情况, 上一位不是0, 且这一位不是0, dp[i]等于dp[i-1] + dp[i-2]
            if (s.charAt(i-1) != '0' && s.charAt(i) != '0' && ((s.charAt(i)- '0') + 10 * (s.charAt(i-1)) - '0') <= 26) {
                dp[i] = i >= 2 ? dp[i-1] + dp[i-2] : dp[i-1] + 1;
            } else if (s.charAt(i) != '0') {
                //前一位是0,这样就无法结合,dp[i] = dp[i-1]
                dp[i] = dp[i-1];
            } else if (s.charAt(i) == '0' && (s.charAt(i-1) == '1' || s.charAt(i) == '2')) {
                //本位是0,且上一位是1或二, 这样可以组成
                dp[i] = i >= 2 ? dp[i-2] : dp[i-1];
            } else {
                return 0;
            }
        }
        return dp[s.length()-1];
    }
}