package top2020.day0908;

/**
 * 实现前缀树
 */
public class Leetcode208 {

    TrieNode root;

    public Leetcode208() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int ch = word.charAt(i) - 'a';
            if (cur.next[ch] == null) {
                cur.next[ch] = new TrieNode();
            }
            cur = cur.next[ch];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int ch = word.charAt(i) - 'a';
            if (cur.next[ch] == null) {
                return false;
            }
            cur = cur.next[ch];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int ch = prefix.charAt(i) - 'a';
            if (cur.next[ch] == null) {
                return false;
            }
            cur = cur.next[ch];
        }
        return true;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] next;

    public TrieNode() {
        isEnd = false;
        next = new TrieNode[26];
    }
}