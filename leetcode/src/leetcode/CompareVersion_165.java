package leetcode;

public class CompareVersion_165 {

    public static void main(String[] args) {
        System.out.println(new CompareVersion_165().compareVersion("7.5.2.4","7.5.3"));
    }


    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        for (i = 0; i < v1.length && i < v2.length; ++i) {
            int ver1 = Integer.parseInt(v1[i]);
            int ver2 = Integer.parseInt(v2[i]);
            if (ver1 > ver2) {
                return 1;
            } else if (ver1 < ver2) {
                return -1;
            }
        }
        if (i < v1.length) {
            while (i < v1.length && Integer.parseInt(v1[i]) == 0) {
                i++;
            }
            if (i == v1.length) {
                return 0;
            }
            return 1;
        }
        if (i < v2.length) {
            while (i < v2.length && Integer.parseInt(v2[i]) == 0) {
                i++;
            }
            if (i == v2.length) {
                return 0;
            }
            return -1;
        }
        return 0;
    }
}
