package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 76
 * 最小覆盖子串
 */
public class _76MinWindow {

    public static void main(String[] args) {
        System.out.println(new _76MinWindow().minWindow("a","b"));
    }




    /**
     * 自己敲的代码,通过率 : 246 / 268
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : t.toCharArray()) {
            int count = map.getOrDefault(c,0);
            map.put(c,count+1);
        }
        int i = 0, j = 0;
        while (i < s.length() && j <= s.length()) {
            if (map.isEmpty()) {
                for (Character c : t.toCharArray()) {
                    int count = map.getOrDefault(c,0);
                    map.put(c,count+1);
                }
                while (!map.containsKey(s.charAt(i))) {
                    ++i;
                }
                if (res.equals("") || s.substring(i,j).length() <= res.length()) {
                    res = s.substring(i,j);
                }
                if (j == s.length()) {
                    break;
                }
                ++i;
                j = i;
                continue;
            }
            if (j == s.length()) {
                break;
            }
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                int count = map.get(c);
                count--;
                if (count == 0) {
                    map.remove(c);
                } else {
                    map.put(c,count);
                }
            }
            j++;

        }
        return res;
    }
}
