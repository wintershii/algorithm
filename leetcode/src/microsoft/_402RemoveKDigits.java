package microsoft;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _402RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder builder = new StringBuilder(num);
        for (int i = 0; i < k; ++i) {
            int idx = 0;
            for (int j = 1; j < builder.length() && builder.charAt(j) >= builder.charAt(j-1); ++j) {
                idx = j;
            }
            builder.deleteCharAt(idx);
            while (builder.length() > 0 && builder.charAt(0) == '0') {
                builder.deleteCharAt(0);
            }
        }
        return builder.toString();
    }
}
