package string;

/**
 * 题目：翻转字符串里的单词
 * 来源:leetcode字节跳动专栏
 */
public class ReverseTheWordOfString {
    public static void main(String[] args) {
        System.out.println(new ReverseTheWordOfString().reverseWords("  the sky is blue"));
    }

    /**
     * 自己写的　一次通过
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) != ' ') {
                        sb.append(s.charAt(j));
                    } else {
                        break;
                    }
                }
                sb.append(' ');
                while (s.charAt(i-1) == ' ') {
                    i--;
                }
            }
            if (i == 0 && s.charAt(i) != ' ') {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) != ' ') {
                        sb.append(s.charAt(j));
                    } else {
                        break;
                    }
                }
            }
        }
        return sb.toString().trim();
    }
}
