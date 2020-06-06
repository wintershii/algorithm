package p06;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive_128 {

    public static void main(String[] args) {
        System.out.println(new LongestConsecutive_128().longestConsecutive(new int[]{1,2,0,1}));
    }

    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            int left = map.getOrDefault(nums[i]-1,0);
            int right = map.getOrDefault(nums[i]+1,0);

            int len = right + left + 1;
            map.put(nums[i],len);
            if (map.containsKey(nums[i]-1)) {
                map.put(nums[i]-left,len);
            }
            if (map.containsKey(nums[i]+1)) {
                map.put(nums[i]+right,len);
            }
            res = Math.max(res,len);
        }
        return res;
    }
}
