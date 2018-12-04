package string;

import java.util.*;

/**
 * 题目:无重复字符的最长子串
 * 来源:字节跳动专栏
 *
 */
public class FindLongestNotRepeatedSonString {

    public static void main(String[] args) {
        String s;
        Scanner scan = new Scanner(System.in);
        s = scan.nextLine();
        System.out.println("" + new FindLongestNotRepeatedSonString().violence(s));

    }


    /**
     * 1.暴力法枚举处所有可能情况,并求解 (超出时间限制)
     * 时间复杂度:O(n^3)
     * @param s
     * @return
     */
    public int violence(String s) {
        int length = s.length();
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {
                if (allUnique(s,i,j)) {
                    ans = Math.max(ans,j - i);
                }
            }
        }

        return ans;
    }

    /**
     * 2.滑动窗口法:使用一个HashSet ,通过判断下一字符是否存在与Set中,从而移动子串左右边界的指针,获取最长子串
     * 时间复杂度O(2n) = O(n)
     * @return
     */
    public int slideWindow(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0, j = 0;
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 3.进一步优化后的滑动窗口
     * 思路:使用Map记录j的重复字符的位置j0,然后不用i++,直接让i=j0+1;
     * 时间复杂度:O(n)
     * @param s
     * @return
     */
    public int optSlideWindow(String s) {
        int length = s.length();
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < length; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j - i + 1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }

    /**
     * 判断字符串中子串是否含有重复的字母
     * @param s
     * @param start
     * @param end
     * @return
     */
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}
