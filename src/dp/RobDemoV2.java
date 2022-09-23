package dp;

/**
 * 213. 打家劫舍 II
 * <p>
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class RobDemoV2 {

    public static void main(String[] args) {
        RobDemoV2 robV2Demo = new RobDemoV2();
        int[] array = new int[]{1, 2};
        System.out.println(robV2Demo.rob(array));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        // 偷第一家
        dp[0] = nums[0];
        // 不偷第二家，所以直接继承第一家。
        dp[1] = dp[0];
        int max = dp[0];
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            max = Math.max(dp[i], max);
        }

        // 不偷第一个家
        dp[0] = 0;
        dp[1] = nums[1];
        max = Math.max(max, dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
