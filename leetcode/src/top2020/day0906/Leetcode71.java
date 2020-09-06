package top2020.day0906;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 简化路径
 */
public class Leetcode71 {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length; ++i) {
            if (strs[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!strs[i].equals("") && !strs[i].equals(".") && !strs[i].equals("..")) {
                stack.push(strs[i]);
            }
        }
        List<String> res = new ArrayList<>(stack);
        return "/" + String.join("/", res);
    }
}
