package p05;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 */
public class FindDuplicate_287 {

    public static void main(String[] args) {
        System.out.println(new FindDuplicate_287().findDuplicate_2(new int[]{1,3,4,2,2}));
    }
    /**
     * 思路3：快慢指针
     */
    public int findDuplicate_2(int[] nums) {
        if (nums.length == 2) {
            return nums[0];
        }
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        slow = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) {
                break;
            }
        }
        return slow;
    }


    /**
     * 思路2：二分法，找到[1 - n]每个位置上数组中小于i的数的个数并记录，若重复的数是target,则[1-target]中，cnt <= i
     * [target - n]中间 cnt > 1
     * @param nums
     * @return
     */
    public int findDuplicate_1(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    /**
     * 思路1：使用set的去重特性检测重复项 空间和时间都是O(n)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return nums[0];
    }
}
