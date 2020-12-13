package top2020.day1009;

import java.util.*;

public class WordDictionary {

    Map<Integer, Set<String>> map = new HashMap<>();

    /** Initialize your data structure here. */
    public WordDictionary() {
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int length = word.length();
        if (map.get(length) != null) {
            map.get(length).add(word);
        } else {
            Set<String> set = new HashSet<>();
            set.add(word);
            map.put(length, set);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int length = word.length();
        if (!map.containsKey(length)) {
            return false;
        }
        Set<String> set = map.get(length);
        if (set.contains(word)) {
            return true;
        }
        char[] chars = word.toCharArray();
        for (String str : set) {
            if (str.length() != chars.length) {
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) != chars[i] && chars[i] != '.') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
