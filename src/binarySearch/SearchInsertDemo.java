package binarySearch;

/**
 * 35. 搜索插入位置
 * <p>
 * https://leetcode.cn/problems/search-insert-position/
 */
public class SearchInsertDemo {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 找到了，就直接返回。
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 如果没有找到，就返回left，三种情况：
        // 1. target 比 nums[0] 小，那么最终left等于0。
        // 2. target 比 nums[nums.length - 1] 大，那么最终left等于 nums.length。
        // 3. target 在最小值和最大值之前，那么left就是在比target 最接近的大值上。
        return left;
    }

    public int searchInsertV2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
