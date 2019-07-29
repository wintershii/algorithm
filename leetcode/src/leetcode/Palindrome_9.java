package leetcode;

public class Palindrome_9 {
    public static void main(String[] args) {
        System.out.println(new Palindrome_9().isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }
}
