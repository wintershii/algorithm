package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.equals("")) {
            return list;
        }
        HashMap<Integer,String> map = new HashMap();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        search(list,digits,"",map,0);
        return list;
    }

    private void search(List list, String digits, String str, HashMap<Integer,String> map, int k) {
        if (str.length() == digits.length()) {
            list.add(str);
            return;
        }
        String tmp = map.get(digits.charAt(k)-'0');

        for (char w : tmp.toCharArray()) {
            String newStr = str + w;
            search(list,digits,newStr,map,k+1);
        }
        return;
    }
}
