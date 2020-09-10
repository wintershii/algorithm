package top2020.day0909;

import java.util.HashMap;
import java.util.Map;

/**
 * 可被K整除的子数组
 * 前缀和
 * 原理：若数组A[0-i]的和对K取余为x，数组A[0-j]的和对K取余为y，且x==y，则A[i+1,j]的数组和能被K整除
 * 故遍历该数组，每次将前缀和对K取余的结果 保存一个 计数器
 * 若之前有该值，res++
 */
public class Leetcode974 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0, res = 0;
        for (int num : A) {
            pre = (pre + num) % K;
            if (pre < 0)
                pre += K;
            res += map.getOrDefault(pre, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}
