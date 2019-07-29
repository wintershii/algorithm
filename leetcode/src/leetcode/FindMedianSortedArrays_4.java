package leetcode;


public class FindMedianSortedArrays_4 {
    public static void main(String[] args) {
        System.out.println();
    }

    public double mySolve(int[] nums1, int[] nums2) {
        int[] num = merge(nums1,nums2);
        int len = num.length;
        if (len % 2 == 0) {
            return ((double)(num[len/2-1] +num[len/2])/2.0);
        } else {
            return (double)num[len/2];
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int p = 0;
        int[] num = new int[nums1.length+nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                num[p++] = nums1[i++];
            } else {
                num[p++] = nums2[j++];
            }
        }
        if (i == nums1.length) {
            for (int k = j; k < nums2.length; k++) {
                num[p++] = nums2[j++];
            }
        } else {
            for (int k = i; k < nums1.length; k++) {
                num[p++] = nums1[i++];
            }
        }
        return num;
    }
}
