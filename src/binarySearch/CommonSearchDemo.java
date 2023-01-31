package binarySearch;

/**
 * 704. 二分查找 -- 经典二分查找。
 * <p>
 * https://leetcode.cn/problems/binary-search/
 */
public class CommonSearchDemo {

    public static void main(String[] args) {

    }

    /**
     * 错误写法。
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int value = nums[mid];
            if (value == target) {
                return mid;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 正确写法1，再错误写法上增加边界处理。
     */
    public int searchV2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int value = nums[mid];
            if (value == target) {
                return mid;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 这里两个都前进或者后退了的，所以都得判断。
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        if (right >= 0 && nums[right] == target) {
            return right;
        }
        return -1;
    }


    /**
     * 正确写法2.
     */
    public int searchV3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int value = nums[mid];
            if (value < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 谁前进或者后退，最后就选择哪一个。
        return left < nums.length && nums[left] == target ? left : -1;
    }
}
