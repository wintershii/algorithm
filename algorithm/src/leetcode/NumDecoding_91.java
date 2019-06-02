package leetcode;

public class NumDecoding_91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0') return 0;
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != '0' && s.charAt(i) != '0' && ((s.charAt(i)- '0') + 10 * (s.charAt(i-1)) - '0') <= 26) {
                dp[i] = i >= 2 ? dp[i-1] + dp[i-2] : dp[i-1] + 1;
            } else if (s.charAt(i) != '0') {
                dp[i] = dp[i-1];
            } else if (s.charAt(i) == '0' && (s.charAt(i-1) == '1' || s.charAt(i) == '2')) {
                dp[i] = i >= 2 ? dp[i-2] : dp[i-1];
            } else {
                return 0;
            }
        }
        return dp[s.length()-1];
    }
}