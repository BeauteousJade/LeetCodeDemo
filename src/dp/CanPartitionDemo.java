package dp;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * <p>
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class CanPartitionDemo {

    public static void main(String[] args) {
        CanPartitionDemo demo = new CanPartitionDemo();
        System.out.println(demo.canPartition(new int[]{1, 2, 3, 5, 23}));
    }

    /**
     * 0-1背包问题。
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int m = nums.length;
        // dp[i][j]:第i个数字，和为j,是否有子集符合。
        boolean[][] dp = new boolean[m + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                // dp[i - 1][j]:不选择当前i,继承i - 1;
                dp[i][j] = dp[i - 1][j];
                if (j >=nums[i - 1]) {
                    // dp[i - 1][j - nums[i]]:选择当前i;
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[m][target];
    }

}
