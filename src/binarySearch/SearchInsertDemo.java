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
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
