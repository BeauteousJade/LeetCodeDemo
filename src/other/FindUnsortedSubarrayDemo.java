package other;

/**
 * 581. 最短无序连续子数组
 * <p>
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class FindUnsortedSubarrayDemo {

    public static void main(String[] args) {

    }


    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        int right = -1;
        // 正序遍历，当前数组中的最大值。
        int currentMaxValue = Integer.MIN_VALUE;
        // 反序遍历，当前数组中最小值。
        int currentMinValue = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (currentMaxValue > nums[i]) {
                right = i;
            } else {
                currentMaxValue = nums[i];
            }
            if (currentMinValue < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                currentMinValue = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
