package classify._9hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 *
 *     如果 S 中不存这样的子串，则返回空字符串 ""。
 *     如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _3SmallestWindowString {

    /**
     * 滑动指针
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        //存放t字符串中的字符和出现次数
        Map<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            int count = tMap.getOrDefault(t.charAt(i),0);
            tMap.put(t.charAt(i),count + 1);
        }
        int i = 0, j = 0;
        int formed = 0;
        int[] ans = {-1,0,0};
        Map<Character,Integer> map = new HashMap<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            int count = map.getOrDefault(c,0);
            map.put(c,count + 1);
            if (tMap.containsKey(c) && tMap.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            while (i <= j && formed == tMap.size()) {
                c = s.charAt(i);
                if (ans[0] == -1 || j - i + 1 < ans[0]) {
                    ans[0] = j - i + 1;
                    ans[1] = i;
                    ans[2] = j;
                }
                map.put(c, map.get(c) - 1);
                if (tMap.containsKey(c) && map.get(c).intValue() < tMap.get(c).intValue()) {
                    formed--;
                }
                i++;
            }
            j++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1],ans[2]+1);
    }
}
