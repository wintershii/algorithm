package p05;

import java.util.HashMap;
import java.util.Map;


public class SubarrayNum_560 {

    /**
     * 与974题类似，前缀和算法
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for (int i : nums) {
            sum += i;
            int prej = sum - k;
            if (map.containsKey(prej)) {
                res += map.get(prej);
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return res;
    }
}
