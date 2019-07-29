package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidBrackets {
    public static void main(String[] args) {
        System.out.println(new ValidBrackets().isValid("}{"));
    }

    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        if (s.length()  < 2) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    if (stack.peek() == '{' || stack.peek() == '[') {
                        stack.pop();
                        return false;
                    }
                    break;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                while (!stack.isEmpty() && stack.peek() != '[') {
                    if (stack.peek() == '{' || stack.peek() == '(') {
                        stack.pop();
                        return false;
                    }
                    break;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                while (!stack.isEmpty() && stack.peek() != '{') {
                    if (stack.peek() == '(' || stack.peek() == '[') {
                        stack.pop();
                        return false;
                    }
                    break;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }

            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;

    }
}
