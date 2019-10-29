package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
 *
 * 示例:
 *
 * 输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _187FindRepeatedDnaSequences {

    public static void main(String[] args) {
        System.out.println(new _187FindRepeatedDnaSequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public List<String> findRepeatedDnaSequences(String s) {

        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        HashSet<String> set = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; ++i) {
            String tmp = s.substring(i,i + 10);
            if (map.containsKey(tmp)) {
                set.add(tmp);
            } else {
                map.put(tmp,1);
            }
        }
        return new ArrayList<>(set);
    }
}
