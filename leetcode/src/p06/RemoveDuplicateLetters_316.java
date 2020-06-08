package p06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplicateLetters_316 {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters_316().removeDuplicateLetters("bcabc"));
    }


    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        HashSet<Character> set = new HashSet<>();

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i),i);
        }

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if ( !set.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }
                set.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
