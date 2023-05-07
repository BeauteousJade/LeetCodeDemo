package backTrack;

import java.util.Arrays;

/**
 * 494. 目标和
 * <p>
 * https://leetcode-cn.com/problems/target-sum/
 */
public class FindTargetSumWaysDemo {

    public static void main(String[] args) {
        FindTargetSumWaysDemo demo = new FindTargetSumWaysDemo();
        System.out.println(demo.findTargetSumWaysV2(new int[]{1, 1, 1, 1, 1}, 3));
    }

    private int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums, 0, 0, target);
        return count;
    }

    private void backTrack(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backTrack(nums, index + 1, sum + nums[index], target);
            backTrack(nums, index + 1, sum - nums[index], target);
        }
    }

    /**
     * sum:和。
     * 正数:sum1
     * 负数：sum2
     * sum = sum1 + sum2
     * sum1 - sum2 = target = sum - 2 * sum2
     * sum2 = (sum - target) / 2
     */
    public int findTargetSumWaysV2(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum - target) % 2 != 0 || sum - target < 0) {
            return 0;
        }
        int diff = (sum - target) / 2;
        int m = nums.length;
        // dp[i][j]:前i个数，和是否为j.
        int[][] dp = new int[m + 1][diff + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= diff; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[m][diff];
    }
}
