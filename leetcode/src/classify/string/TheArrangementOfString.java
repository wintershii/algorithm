package classify.string;

import java.util.Arrays;

/**
 * 题目:字符串的排列
 * 来源:leetcode字节跳动专栏
 */
public class TheArrangementOfString {
    public static void main(String[] args) {

        System.out.println(new TheArrangementOfString().checkInclusion("adc","dcda"));
    }


    /**
     * 滑动窗口解题 (哎...之前已经用过这种算法了,但是碰到题还是想不出来)
     * 时间复杂度O(n)
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        //s1长度
        int l1 = s1.length();
        //s2长度
        int l2 = s2.length();
        //s1的标记数组,记录每个字符的出现次数
        int[] c1 = new int[26];
        //s2的标记数组
        int[] c2 = new int[26];
        //遍历s1,记录s1中各字符的出现次数
        for(char c : s1.toCharArray())
            c1[c - 'a']++;
        //遍历s2
        for(int i = 0; i < l2; i++)
        {
            //若长度超过了l1的长度,就把之前查过的字符还原
            if(i >= l1) {
                --c2[s2.charAt(i-l1)-'a'];//先把坐标查过的
            }
            //记录出现的字符
            c2[s2.charAt(i)-'a']++;
            if(Arrays.equals(c1, c2))
                return true;
        }
        return false;
    }


    /**
     * 自己的暴力写法,一半多用例之后超出时间限制了....
     * 思路:构造一个类,保存了s1中每个字符的下标,字符,还有是否被访问的标记
     * 然后遍历s2,挨个遍历字符,判断其是否存在与s1中,并且改变数组内的标记值
     * 每向后移动一个字符,如果符合条件,就给ans自增,若有一处断开,则ans归0
     * 双层循环 判断条件又是一次遍历 时间复杂度O(n^3)
     * @param s1
     * @param s2
     * @return
     */
    public boolean violence(String s1, String s2) {
        if (s1 == null ||s1.length() == 0) {
            return true;
        }

        if (s2 == null || s2.length() == 0 || s2.length() < s1.length()) {
            return false;
        }

        int ans = 0;
        int max = 0;
        Attom[] attoms = new Attom[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            attoms[i] = new Attom();
            attoms[i].index = i;
            attoms[i].character = s1.charAt(i);
            attoms[i].visited = false;
        }

        for (int k = 0; k < s2.length(); k++) {
            for (int i = k; i < s2.length(); i++) {
                if (isFinded(attoms, s2.charAt(i))) {
                    ans++;
                } else {
                    ans = 0;
                    for (int j = 0; j < s1.length(); j++) {
                        attoms[j].visited = false;
                    }
                }
                if (ans > max) {
                    max = ans;
                }
            }
            ans = 0;
            for (int j = 0; j < s1.length(); j++) {
                attoms[j].visited = false;
            }
        }

        if (max >= s1.length()) {
            return true;
        }
        return false;
    }

    public boolean isFinded(Attom[] attoms, char character) {
        for (int i = 0; i < attoms.length; i++) {
            if (character == attoms[i].character && !attoms[i].visited) {
                attoms[i].visited = true;
                return true;
            }
        }
        return false;
    }

}

class Attom {
    int index;
    char character;
    boolean visited;
}
