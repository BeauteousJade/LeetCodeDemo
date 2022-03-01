package binarySearch;

/**
 * 搜索旋转排序数组
 * <p>
 * 找到有序的一边，如果target在有序的里面，直接在有序的里面找，否则就在另一边找。
 */
public class SearchDemo {

    public static void main(String[] args) {
        SearchDemo demo = new SearchDemo();

        System.out.println(demo.search(new int[]{5, 1, 2, 3, 4}, 1));
    }

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
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
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
