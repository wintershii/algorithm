package leetcode;

public class LengthOfLastWord_58 {

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord_58().lengthOfLastWord(" "));
    }
    public int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            ++count;
        }
        return count;
    }
}
