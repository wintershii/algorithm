package p05;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 */
public class FindMedian_4 {

    public static void main(String[] args) {
        System.out.println(new FindMedian_4().findMedianSortedArrays(new int[]{2},new int[]{1,3,4}));
    }

    /**
     * 思路3：二分的思想，相当于求第k大的数
     */
    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        if (left == right) {
            return (double)(getKth(nums1,0,m-1,nums2,0,n-1,left));
        }
        return (double)(getKth(nums1,0,m-1,nums2,0,n-1,left) + getKth(nums1,0,m-1,nums2,0,n-1,right)) / 2.0;
    }

    public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return getKth(nums2,start2,end2,nums1,start1,end1,k);
        }
        if (len1 == 0) {
            return nums2[start2 + k -1];
        }
        if (k == 1) {
            return Math.min(nums1[start1],nums2[start2]);
        }
        int i = start1 + Math.min(len1,k/2) - 1;
        int j = start2 + Math.min(len2,k/2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1,start1,end1,nums2,j+1,end2,k - (j-start2+1));
        } else {
            return getKth(nums1,i+1,end1,nums2,start2,end2,k - (i-start1+1));
        }

    }


    /**
     * 思路1：合并两个数组到一个数组中形成一个有序数组，然后再根据m+n是奇数还是偶数确定中位数 空间复杂度O(m+n) 时间复杂度O(m+n)
     * 思路2：并不存放真正的数组，用双指针找到对应的位置即可
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;
        int count = 0;
        boolean flag;
        if (((m + n) & 1) == 1) {
            flag = true;
        } else {
            flag = false;
        }
        if (m == 0) {
            if (flag) {
                return nums2[n/2];
            }
            return  (double) (nums2[n/2-1] + nums2[n/2]) / 2.0;
        }
        if (n == 0) {
            if (flag) {
                return nums1[m/2];
            }
            return (double) (nums1[m/2-1] + nums1[m/2]) / 2.0;
        }
        int last = Math.min(nums1[0],nums2[0]);

        while (i < m && j < n) {
            if (flag) {
                if (count == (m + n) / 2) {
                    return Math.min(nums1[i],nums2[j]);
                }
            } else {
                if (count == (m+n) / 2) {
                    if (nums1[i] > nums2[j]) {
                        return (double)(last + nums2[j]) / 2.0;
                    } else {
                        return (double)(nums1[i] + last) / 2.0;
                    }
                }
            }
            if (nums1[i] < nums2[j]) {
                i++;
                last = nums1[i-1];
            } else {
                j++;
                last = nums2[j-1];
            }
            count++;
        }
        if (i >= m) {
            while (j < n) {
                if (flag) {
                    if (count == (m + n) / 2) {
                        return nums2[j];
                    }
                } else {
                    if (count == (m + n) / 2) {
                        if (j == 0) {
                            return (double)(nums1[i-1] + nums2[j]) / 2.0;
                        }
                        return (double)(last + nums2[j]) / 2.0;
                    }
                }
                count++;
                j++;
                last = nums2[j-1];
            }

        }

        if (j >= n) {
            while (i < m) {
                if (flag) {
                    if (count == (m + n) / 2) {
                        return nums1[i];
                    }
                } else {
                    if (count == (m + n) / 2) {
                        if (i == 0) {
                            return  (double)(nums2[j-1] + nums1[i]) / 2.0;
                        }
                        return  (double)(last + nums1[i]) / 2.0;
                    }
                }
                count++;
                i++;
                last = nums1[i-1];
            }

        }
        return 0;
    }

}
