package dp;

/**
 * 198. 打家劫舍
 * <p>
 * https://leetcode-cn.com/problems/house-robber/
 */
public class RobDemo {

    public static void main(String[] args) {
        RobDemo demo = new RobDemo();
        int array[] = new int[]{2, 7, 9, 3, 1};
        System.out.println(demo.rob(array));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // dp[i - 1]:当前不偷。
            // dp[i - 2] + nums[i]:当前偷，那么上一个就不偷。
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

}
