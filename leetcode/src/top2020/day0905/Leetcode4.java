package top2020.day0905;

/**
 * 寻找两个有序数组的中位数
 * 暴力：合并两个数组，找中位数。On
 * 需要使用二分 达到Ologm+n
 *
 */
public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = m;
        int m1 = 0, m2 = 0;
        while (left <= right) {
            int i = (left + right) >> 1;
            int j = ((m + n + 1) >> 1) - i;

            int numis1 = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
            int numi = i == m ? Integer.MAX_VALUE : nums1[i];
            int numjs1 = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
            int numj = j == n ? Integer.MAX_VALUE : nums2[j];

            if (numis1 <= numj) {
                m1 = Math.max(numis1, numjs1);
                m2 = Math.min(numi, numj);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m+n) % 2 == 0 ? (m1 + m2) / 2.0 : m1;
    }
}
