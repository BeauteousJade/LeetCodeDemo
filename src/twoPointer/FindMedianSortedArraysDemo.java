package twoPointer;

/**
 * 4. 寻找两个正序数组的中位数
 * <p>
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArraysDemo {

    public static void main(String[] args) {
        FindMedianSortedArraysDemo demo = new FindMedianSortedArraysDemo();
        int[] nums1 = {3, 4};
        int[] nums2 = {};
        System.out.println(demo.findMedianSortedArraysV2(nums1, nums2));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int count = len / 2;
        int i = 0;
        int j = 0;
        int res1 = -1;
        int res2 = -1;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                if (i + j == count - 1) {
                    res1 = nums1[i];
                } else if (i + j == count) {
                    res2 = nums1[i];
                }

                i++;
            } else {
                if (i + j == count - 1) {
                    res1 = nums2[j];
                } else if (i + j == count) {
                    res2 = nums2[j];
                }
                j++;
            }

        }
        while (i < nums1.length) {
            if (i + j == count - 1) {
                res1 = nums1[i];
            } else if (i + j == count) {
                res2 = nums1[i];
            }
            i++;
        }
        while (j < nums2.length) {
            if (i + j == count - 1) {
                res1 = nums2[j];
            } else if (i + j == count) {
                res2 = nums2[j];
            }
            j++;
        }
        return len % 2 == 0 ? (res1 + res2) / 2.0 : res2;
    }


    private double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
        int len = (nums1.length + nums2.length) / 2;
        int index1 = 0;
        int index2 = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i <= len; i++) {
            left = right;
            if (index1 < nums1.length && (index2 >= nums2.length || nums1[index1] <= nums2[index2])) {
                right = nums1[index1++];
            } else {
                right = nums2[index2++];
            }
        }
        return (nums1.length + nums2.length) % 2 == 0 ? (left + right) / 2.0 : right;
    }
}
