package shopee;

/**
 * 虾皮一面题目
 */

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class YiMian {
    static int res;
    static boolean flag;
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 1);
        map.put("def", 2);
        map.put("g", 7);
        System.out.println(solve(map, "abcdefg", 2));
    }

    public static int solve(Map<String, Integer> map, String s, int k) {
        res = -1;
        flag = false;
        dfs(map, s, k, 0, 0, 0);
        if (!flag)
            return -1;
        return res;
    }

    private static void dfs(Map<String, Integer> map, String s, int k, int now, int tmp, int index) {
        if (index == k - 1) {
            String str = s.substring(now);
            //System.out.println(str);
            //System.out.println(tmp);
            if ( !map.containsKey(str))
                return;
            tmp += map.get(str);
            flag = true;
            if (tmp > res) {
                res = tmp;
            }
            return;
        }
        for (int i = now + 1; i < s. length(); ++i) {
            String str = s.substring(now, i);
            //System.out.println(str);
            if ( !map.containsKey(str))
                continue;
            dfs(map, s, k, i, tmp + map.get(str), index + 1);
        }
    }
}