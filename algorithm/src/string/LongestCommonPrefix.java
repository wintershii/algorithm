package string;

/**
 * 题目:最长公共前缀,编写一个方法来查找字符串数组的最长公共前缀
 * 来源:字节跳动专栏
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().violence(new String[]{"dog","racecar","car"}));
    }

    /**
     * 1.暴力解法,二层循环
     * 时间复杂度 O(n^2)
     * @param strs
     * @return
     */
    public String violence(String[] strs) {
        int k = 0;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        if (strs.length == 0) {
            return "";
        }
        int min = 9999999;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min && strs[i].length() > 1) {
                min = strs[i].length();
            }
        }
        while (k < min - 1) {
            for (int i = 1; i < strs.length; i++) {
                boolean book = true;
                if (strs[i].length() == 0) {
                    return "";
                }
                if(!(strs[i].charAt(k) == strs[0].charAt(k))) {
                    flag = true;
                    book = false;
                    break;
                }
                if (i == strs.length - 1 && book) {
                    sb.append(strs[0].charAt(k));
                    k++;
                }
            }
            if (flag) {
                break;
            }
        }
        return sb.toString();
    }

    /**
     * 2.牛逼的解法...
     * @param strs
     * @return
     */
    public String optAlgorithm(String[] strs) {
        int count = strs.length;
        String prefix = "";
        if(count != 0){
            prefix = strs[0];
        }
        for(int i=0; i<count; i++){
            //关键代码，不断的从后往前截取字符串，然后与之相比，直到startsWith()返回true
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;

    }



}
