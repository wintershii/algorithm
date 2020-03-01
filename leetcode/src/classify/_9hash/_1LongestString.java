package classify._9hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文串
 */
public class _1LongestString {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        boolean flag = false;
        int maxLength = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i],1);
            } else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            int v = (int)(entry.getValue());
            if ((v & 1) != 1) {
                maxLength += v;
            } else {
                maxLength += v - 1;
                flag = true;
            }
        }
        if (flag) {
            return maxLength + 1;
        }
        return maxLength;
    }
}
