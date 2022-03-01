package dp;

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
        int total = 0;
        int maxNum = 0;
        for (int num : nums) {
            total += num;
            maxNum = Math.max(maxNum, num);
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        if (maxNum > target) {
            return false;
        }
        // dp[i][j]:第i个数字，和为j,是否有子集符合。
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i]) {
                    // dp[i - 1][j]:不选择当前i,继承i - 1;
                    // dp[i - 1][j - nums[i]]:选择当前i;
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }


}
