package p05;

import java.util.Collections;
import java.util.LinkedList;

public class DecodeString_394 {

    public static void main(String[] args) {
        System.out.println(new DecodeString_394().decodeString("3[a]2[bc]"));
    }

    int ptr;

    public String decodeString(String s) {
        LinkedList<String> list = new LinkedList<>();
        while (ptr < s.length()) {
            if (Character.isDigit(s.charAt(ptr))) {
                String num = getDigit(s);
                list.addLast(num);
                //System.out.println(num);
            } else if (Character.isLetter(s.charAt(ptr)) || s.charAt(ptr) == '[') {
                list.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(list.peekLast())) {
                    sub.addLast(list.removeLast());
                }
                Collections.reverse(sub);
                list.removeLast();
                int repTime = Integer.parseInt(list.removeLast());
                StringBuilder sb = new StringBuilder();
                String str = getString(sub);
                while (repTime-- > 0) {
                    sb.append(str);
                }
                list.addLast(sb.toString());
            }
        }
        return getString(list);
    }

    private String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr++));
        }
        return sb.toString();
    }


    private String getString(LinkedList<String> sub) {
        StringBuilder sb = new StringBuilder();
        for (String s : sub) {
            sb.append(s);
        }
        return sb.toString();
    }
}
