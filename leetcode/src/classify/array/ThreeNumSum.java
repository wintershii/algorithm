package classify.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 题目：三数之和
 * 来源:leetcode字节跳动专栏
 */
public class ThreeNumSum {
    public static void main(String[] args) {
        System.out.println(new ThreeNumSum().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }

    /**
     * 双指针法
     * 先给数组排序
     * 选定一个值，在其后面元素的首尾各自设一个指针
     * 考虑　三数相加后=0,<0,>0的情况
     * 然后根据不同情况调整指针指向
     *　再加上去重
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int j,k;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            k = nums.length - 1;

            while (j < k) {
                if (nums[j] + nums[k] + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    while (j < k && nums[j-1] == nums[j]) {
                        j++;
                    }
                    k--;
                } else if (nums[j] + nums[k] + nums[i] < 0) {
                    j++;
                    while (j < k && nums[j-1] == nums[j]) {
                        j++;
                    }
                } else {
                    k--;
                }
            }

            while (i + 1 < nums.length - 2 && nums[i] == nums[i+1]) {
                i++;
            }

        }
        return result;
    }

    /**
     *暴力法：三分之一通过率...
     * 在判断是否有重复　情况的地方有瑕疵，一些情况没有考虑进去
     */
    public List<List<Integer>> violence(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums.length && j != i; j++) {
                for (int k = 0; k < nums.length && k != i && k!= j; k++) {
                    List<Integer> list = null;
                    if (nums[i] + nums[j] + nums[k] == 0 && check(set,nums[i],nums[j],nums[k])) {
                        list = new ArrayList<>();
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[k]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public boolean check(HashSet<Integer> set,int i, int j, int k) {
        if (set.contains(i) && set.contains(j) && set.contains(k)) {
            return false;
        }
        return true;
    }
}
