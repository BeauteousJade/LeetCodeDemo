package other;

import java.util.Arrays;

/**
 * 合并两个有序数组.
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArrayDemo {

    public static void main(String[] args) {
        MergeSortedArrayDemo demo = new MergeSortedArrayDemo();
        int[] nums1 = new int[]{0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        demo.merge(nums1, 0, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < n) {
            int value = nums2[index2];
            while (nums1[index1] < value && index1 < m + index2) {
                index1++;
            }

            for (int i = m + index2; i > index1; i--) {
                nums1[i] = nums1[i - 1];
            }
            nums1[index1] = value;
            index2++;
        }
    }
}
