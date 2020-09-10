package top2020.day0909;

import java.util.*;

/**
 * 删除无效的括号
 * 思路：bfs
 * 使用一个队列，依次尝试删除0 - s.length-1 各个位置上的括号，并验证是否格式
 * set去重，exist用来检测是否需要继续搜索
 */
public class Leetcode301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        set.add(s);
        boolean exist = false;
        while ( !queue.isEmpty()) {
            String curStr = queue.poll();
            if (judge(curStr)) {
                exist = true;
                res.add(curStr);
            }
            if (exist) {
                continue;
            }
            for (int i = 0; i < curStr.length(); ++i) {
                if (!Character.isLetter(curStr.charAt(i))) {
                    String newStr = curStr.substring(0, i) + curStr.substring(i+1);
                    if (!set.contains(newStr)) {
                        queue.offer(newStr);
                        set.add(newStr);
                    }
                }
            }
        }
        return res;
    }

    private boolean judge(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}
