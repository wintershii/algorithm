package ms325;

import java.util.*;

/**
 * 将N个数字划分成N/K组，每组K个数字，每组中的数字互不相同，求每个子数组最大最小元素的差值之和的最小值
 * 输入：
 * N=12, K=3
 * arr=3,3,4,4,5,5,6,6,8,8,10,10
 *
 * 输出：
 * 15
 * {3,4,5,6}	6-3=3
 * {3,4,8,10}	10-3=7
 * {5,6,8,10}	10-5=5
 * 3+7+5=15
 */
public class NoOne {

    int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(new NoOne().solve(12, 4, new int[]{3,3,4,4,5,5,6,6,8,8,10,10}));
    }

    public int solve(int N, int K, int[] arr) {
        if (N % K != 0) {
            return 0;
        }
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int appearMax = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            appearMax = Math.max(appearMax, map.get(num));
        }
        if (appearMax > (N / K)) {
            return 0;
        }
        int[] num = new int[N];
        int[] flag = new int[N];
        helper(N, K, 0, arr, num, flag);
        return res;
    }

    public void helper(int N, int K, int index, int[] arr, int[] num, int[] flag) {
        if (index == N) {
            //System.out.println(11111);
            int sum = 0;
            for (int i = 0; i < num.length; ) {
                //System.out.print(num[i] + " ");
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int j = i; j < i + K; ++j) {
                    min = Math.min(min, num[j]);
                    max = Math.max(max, num[j]);
                }
                sum += Math.abs(max - min);
                i += K;
            }
            res = Math.min(res, sum);
            return;
        }
//        for (int i = 0; i < index; ++i) {
//            System.out.print(num[i] + " ");
//        }
//        System.out.println();
        for (int i = 0; i < N; ++i) {
            if (flag[i] == 0 && (index == 0 || arr[i] != num[index-1])) {
                flag[i] = 1;
                num[index] = arr[i];
                Set<Integer> set = new HashSet<>();
                for (int j = (index/K)*K; j < j + K && j <=index; ++j) {
                    if (set.contains(num[j])) {
                        flag[i] = 0;
                        num[index] = 0;
                        return;
                    }
                    set.add(num[j]);
                }
                helper(N, K, index+1, arr, num, flag);
                flag[i] = 0;
                num[index] = 0;
            }
        }
    }
}
