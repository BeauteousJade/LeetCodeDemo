package twoPointer;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * <p>
 * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class TwoSumDemoV2 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0, 0};
    }
}
