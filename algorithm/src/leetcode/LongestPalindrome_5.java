package leetcode;

public class LongestPalindrome_5 {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome_5().mySolve("babadcccc"));
    }


    /**
     * 自己写的暴力解法，枚举所有子串，依次判定
     * @param s
     * @return
     */
    public String mySolve(String s) {
        String ans = "";
        int len = s.length();
        boolean[][] book = new boolean[len][len+1];
        for (int i = 0; i < len; ++i) {
            for (int j = i+1; j <= len; ++j) {
                String tmp = s.substring(i,j);
                if (book[i][j] == false && check(tmp)) {
                    book[i][j] = true;
                    if (j-i > ans.length()) {
                        ans = tmp;
                    }
                    while (i > 0 && j < len - 1 && s.charAt(i-1) == s.charAt(j+1)) {
                        ans = s.substring(i-1,j+1);
                        System.out.println(ans);
                        book[i-1][j+1] = true;
                        --i;
                        ++j;
                    }
                }
            }
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        String ans = s.substring(0,1);
        int i, j;
        for (i = 0, j = 2; i < s.length() && j < s.length(); ) {
            String tmp = s.substring(i,j);
            if (!check(tmp)) {
                ++j;
            } else {
                if (j - i > ans.length()) {
                    ans = tmp;
                }
                ++i;
            }
        }
        return ans;
    }


    /**
     * 检查字符串是否是回文串
     * @param s
     * @return
     */
    public boolean check(String s) {
        int len = s.length();
        for (int i = 0; i < len/2; ++i) {
            if (s.charAt(i) != s.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }
}
