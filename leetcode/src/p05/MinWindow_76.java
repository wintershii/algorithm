package p05;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinWindow_76 {

    public static void main(String[] args) {
        System.out.println(new MinWindow_76().minWindow_1("ADOBECODEBANC","ABC"));
    }

    public String minWindow_1(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        if (s.contains(t)) {
            return t;
        }
        Map<Character,Integer> stand = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            stand.put(t.charAt(i), stand.getOrDefault(t.charAt(i),0) + 1);
        }
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int formed = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        while (right < s.length()) {
            if (stand.containsKey(s.charAt(right))) {
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0) + 1);
            }

            if (stand.containsKey(s.charAt(right)) && stand.get(s.charAt(right)).intValue() == map.get(s.charAt(right)).intValue()) {
                formed++;
            }
            while (left <= right && formed == stand.size()) {
                if ((right - left + 1) < min) {
                    min = right - left +1;
                    res = s.substring(left,right + 1);
                }
                if (stand.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                }
                if (stand.containsKey(s.charAt(left)) && map.get(s.charAt(left)) < stand.get(s.charAt(left))) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return res;
    }


    /**
     * 自己的写法，虽然也是滑动窗口，但是思路还是有些乱，时间空间优化不够
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.equals("") || s.length() < t.length()) {
            return "";
        }
        if (s.contains(t)) {
            return t;
        }
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> stand = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            map.put(t.charAt(i),0);
            stand.put(t.charAt(i),stand.getOrDefault(t.charAt(i),0) + 1);
        }

        int left = 0;
        int right = 0;
        String res = "";
        int len = Integer.MAX_VALUE;
        while (left <= right) {
            //System.out.println(left + " " + right);
            if (right < chars.length) {
                if (t.contains(chars[right] + "")) {
                    map.put(chars[right],map.get(chars[right]) + 1);
                    while (allContain(map,stand)) {
                        if (map.containsKey(chars[left])) {
                            map.put(chars[left],map.get(chars[left]) - 1);
                        }
                        if ((right - left + 1) < len) {
                            len = (right - left + 1);
                            res = s.substring(left,right +1);
                        }
                        left++;
                    }
                }
                right++;
            }
            else {
                if (allContain(map,stand)) {
                    while (allContain(map,stand)) {
                        if (map.containsKey(chars[left])) {
                            map.put(chars[left],map.get(chars[left]) - 1);
                        }

                        if (right - left < len) {
                            len = right - left;
                            if (right == chars.length) {
                                res = s.substring(left,right);
                            } else {
                                res = s.substring(left,right +1);
                            }
                        }
                        left++;
                    }
                } else {
                    left++;
                }

            }

        }
        return res;
    }


    private boolean allContain(Map<Character,Integer> map, Map<Character,Integer> stand) {
        for (Character c : map.keySet()) {
            if (map.get(c) < stand.get(c)) {
                return false;
            }
        }
        return true;
    }
}
