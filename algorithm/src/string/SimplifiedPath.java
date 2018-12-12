package string;

import java.util.*;

/**
 * 题目：简化路径
 * 来源:leetcode字节跳动专栏
 */
public class SimplifiedPath {
    public static void main(String[] args) {
        System.out.println(new SimplifiedPath().simplifyPath("/a/./b/../c/"));
    }

    /**
     * 先将字符串根据"/"分开
     * 利用栈，当出现"."时忽略,当出现".."时弹栈,当出现""时不管
     * 最后用String.join这个方法，使每个字符串之间加入了"/"
     *
     *
     * 注意！！！　本题不能使用Deque来模拟栈，因为在最后的 List list = new ArrayList(stack)时
     * 构造器接受的参数类型　如果用Deque，就会被当成队列，然后顺序就会反
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");
        for (String str : strings) {
            if ( !stack.isEmpty() && str.equals("..")) {
                stack.pop();
            } else if ( !str.equals(".") && !str.equals("") && !str.equals("..")) {
                stack.push(str);
            }
        }

        List<String> list = new ArrayList<>(stack);
        return "/" + String.join("/",list);

    }
}
