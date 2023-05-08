package binarySearch;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
 */
public class MissingNumberDemo {

    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            // 如果当前值等于 mid，表示丢失的数字在右侧。
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
