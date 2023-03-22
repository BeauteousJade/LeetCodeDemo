package binarySearch;

/**
 * 33. 搜索旋转排序数组
 * <p>
 * 找到有序的一边，如果target在有序的里面，直接在有序的里面找，否则就在另一边找。
 * <p>
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchDemo {

    public static void main(String[] args) {
        SearchDemo demo = new SearchDemo();

        System.out.println(demo.search(new int[]{5, 1, 2, 3, 4}, 1));
    }

    // TODO pangbingyu03
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 第一个数比中间数小，那么就先确定左侧。
            if (nums[0] <= nums[mid]) {
                // 第一个数小于目标数，同时目标数小于中间数，表示目标数在左侧。
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else { // 其他的在右侧。
                    l = mid + 1;
                }
            } else { // 先确定右侧
                // 中间数小于目标数，同时目标数小于最后一个数，表示目标是在右侧。
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
