package classify.array;

import java.util.Arrays;

/**
 * 题目：搜索旋转排序数组
 * 来源:leetcode字节跳动专栏
 */
public class SearchCircleSortArray {
    public static void main(String[] args) {
        System.out.println(new SearchCircleSortArray().search(new int[]{22,31,89,0,3,7,9},3));

    }

    /**
     * 网上找到的AC代码，好好研究了一番
     * 与传统二分查找代码比较：　仍然是左右中三个指针
     * 但是利用了中指针的值与两边指针值比较，获取有序序列
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //每次循环开始更新mid值
            int mid = (left + right) / 2;
            //查找到元素
            if (nums[mid] == target) return mid;
            if (nums[mid] == nums[left]) left++;   //重复了，跳过
            //mid指针左边序列有序,
            else if (nums[mid] > nums[left]) {
                //判断target是否在这个有序序列当中　left--mid之间
                if (nums[mid] > target && nums[left] <= target)
                    //如果在,则让right指针更新到mid左边
                    right = mid - 1;
                //如果不在,那么就让left指针更新到mid右边
                else left = mid + 1;
            } else {
                //与上面的条件相反,判断
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }



    /**
     * 普通的二分搜索
     * @param nums
     * @param target
     * @return
     */
    public int mySearch(int[] nums, int target) {
        Arrays.sort(nums);
        int middle = nums.length / 2;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                i = middle + 1;
            } else if (target < nums[middle]) {
                j = middle - 1;
            }
            middle =  i + (j - i) / 2;
        }
        return -1;
    }
}
