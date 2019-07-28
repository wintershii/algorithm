package leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome_125 {

    public static void main(String[] args) {
        System.out.println(new IsPalindrome_125().isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
             if ((c >= '0' && c <='9') || (c >= 'a' && c <= 'z') ||  (c >= 'A' && c <= 'Z')) {
                 sb.append(c);
             }
        }
        String real = sb.toString();
        for (int i = 0; i < real.length(); i++) {
            char c1 = real.charAt(i);
            char c2 = real.charAt(real.length() - i - 1);
            if (isWord(c1) && isWord(c2)) {
                if ((c1 == c2) || (c1 == c2 + 32)|| (c1 == c2-32)) {
                } else {
                    return false;
                }
            } else {
                if ((c1 == c2)) {
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean isWord(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
