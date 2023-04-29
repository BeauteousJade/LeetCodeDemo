package twoPointer;

import java.util.Arrays;

/**
 * 259. 较小的三数之和
 * <p>
 * https://leetcode.cn/problems/3sum-smaller/
 */
public class ThreeSumSmallerDemo {

    public static void main(String[] args) {
        ThreeSumSmallerDemo demo = new ThreeSumSmallerDemo();
        int[] array = {-2, 0, 1, 3};
        System.out.println(demo.threeSumSmaller(array, 2));
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            res += twoSum(nums, i + 1, target - nums[i]);
        }
        return res;
    }

    private int twoSum(int[] nums, int startIndex, int target) {
        int left = startIndex;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                // 一共有right - left组。分别是(left, left + 1).. (left, right);
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
