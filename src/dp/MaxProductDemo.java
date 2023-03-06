package dp;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
// TODO 下次
public class MaxProductDemo {

    public static void main(String[] args) {
        MaxProductDemo demo = new MaxProductDemo();
        int[] array = new int[]{2, -1, 1, 1};
        System.out.println(demo.maxProduct(array));
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int result = max[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(nums[i], min[i - 1] * nums[i]));
            result = Math.max(max[i], result);
        }
        return result;
    }

}
