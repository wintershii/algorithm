package leetcode;

public class TitleToNumber_171 {
    public static void main(String[] args) {
        System.out.println(new TitleToNumber_171().titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int ato = 1;
        for (int i = chars.length - 1; i >= 0; --i) {
            res += ((chars[i] - 'A' + 1) * ato );
            ato *= 26;
        }
        return res;
    }
}
