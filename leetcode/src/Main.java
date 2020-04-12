import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"tea","ate","one","eat","pat","apt","eno","ooone","oeoon"};
        int n = strs.length;
        Map<String,Integer> map = new HashMap<>();
        int num = 0;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                List<String> list = res.get(map.get(key));
                list.add(strs[i]);
            } else {
                map.put(key,num);
                num++;
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                res.add(list);
            }
        }
        System.out.println(res);
    }

    private static int findLongest(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int[] dp = new int[arr.length+1];
        dp[0] = 0;
        dp[1] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 2; i <= arr.length; ++i) {
            for (int j = 1; j < i; ++j) {
                if (arr[i-1] >= arr[j-1] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            if (dp[i] > res) {
                res = dp[i];
            }
        }

        return res;
    }
}
