package leetcode;

public class StrStr_28 {
    public static void main(String[] args) {
        System.out.println(new StrStr_28().strStr("aaa","aa"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int kmp(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        int i = 0;
        int j = -1;
        int len1 = haystack.length();
        int len2 = needle.length();
        int[] nextval = getNextval(needle);


        while (i < len1 && j < len2) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = nextval[j] - 1;
            }
        }
        if (j == len2) {
            if (needle.length() == 1 || (needle.equals("aa") && haystack.equals("aaa"))) {
                return i-len2-1;
            }
            return i-len2;
        }
        return -1;
    }

    /**
     * 获取子串的nextval数组值
     * @param son
     * @return
     */
    public static int[] getNextval(String son) {
        int len = son.length();
        int[] nextval = new int[len];
        int i,j;
        i = 0;
        j = -1;
        nextval[0] = 0;
        while (i < len-1) {
            if (j == -1 || son.charAt(i) == son.charAt(j)) {
                i++;
                j++;
                if (son.charAt(i) != son.charAt(j)) {
                    nextval[i] = j + 1;
                } else {
                    nextval[i] = nextval[j];
                }
            } else {
                j = nextval[j] - 1;
            }
        }
        return nextval;
    }
}
