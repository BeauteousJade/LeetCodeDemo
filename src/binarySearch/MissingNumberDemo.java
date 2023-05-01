package binarySearch;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
 */
public class MissingNumberDemo {

    public static void main(String[] args) {

    }

    /**
     * 1.先看是否left等于right，如果等于就两个都变，结果优先选择left。
     * 2.如果不能等于就一个变，最终结果选择变得那个。
     */
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
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

    public int missingNumberV2(int[] nums) {
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
