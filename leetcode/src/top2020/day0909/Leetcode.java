package top2020.day0909;

import java.util.*;

/**
 * 去除重复字母
 * 给你一个仅包含小写字母的字符串，
 * 请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）
 *
 * 思路：使用map（统计字母最后出现的下标）
 * stack（暂存字母）
 * set判断是否重复
 * 遍历，并进行入栈判断。保证有序
 * 最终reverse
 */
public class Leetcode {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (!set.contains(s.charAt(i))) {
                while (!stack.isEmpty() && s.charAt(i) < stack.peek() && map.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }
                set.add(s.charAt(i));
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
