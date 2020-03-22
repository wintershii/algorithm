package ali;

import java.util.*;

public class UpString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            strs.add(scan.nextLine());
        }
        strs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0) == o2.charAt(0)) {
                    return o2.length() > o1.length() ? 1 : 0;
                } else {
                    return o2.charAt(0) < o1.charAt(0) ? 1 : -1;
                }
            }
        });
        System.out.println(strs);
        int[] dp = new int[n];
        dp[0] = strs.get(0).length();
        int res = 0;
        for (int i = 1; i < n; ++i) {
            int pre = 0;
            for (int j = i - 1; j >= 0; --j) {
                if (strs.get(i).charAt(0) < strs.get(j).charAt(strs.get(j).length() - 1))
                    continue;
                pre = Math.max(pre,dp[j]);
            }
            dp[i] = pre + strs.get(i).length();
            res = Math.max(res,dp[i]);
        }
        System.out.println(res);
    }
}
