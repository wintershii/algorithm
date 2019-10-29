package leetcode;

public class _58LengthOfLastWord {

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
