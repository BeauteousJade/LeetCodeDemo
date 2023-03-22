package binarySearch;

/**
 * 540. 有序数组中的单一元素
 * <p>
 * https://leetcode.cn/problems/single-element-in-a-sorted-array/
 */
public class SingleNonDuplicateDemo {

    public static void main(String[] args) {

    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                // 如果当前mid 等于 偶数，且nums[mid] == nums[mid + 1]，表示left 之前的都是出现两次的数。
                // 所以结果应该在 right 上。
                if (mid % 2 == 0) {
                    left = mid + 2;
                } else {
                    // 反之则在left 上。
                    right = mid - 1;
                }
            } else if (mid > 0 && nums[mid] == nums[mid - 1]) {
                // 如果当前的mid 等于 偶数，且nums[mid] == nums [mid - 1]，left 上出现了一个单数。
                // 此时right = mid - 2。
                if (mid % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        // 由于题目的性质，一定会被找到，所以不会返回-1
        return -1;
    }
}
