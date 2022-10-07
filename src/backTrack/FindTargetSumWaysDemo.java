package backTrack;

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

    public int findTargetSumWaysV2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        //记数组的元素和为 sum，添加- 号的元素之和为neg，则其余添加+的元素之和为sum−neg，
        // 得到的表达式的结果为：
        // (sum − neg) − neg= sum − 2 * neg = target
        // 得出结果：neg = (sum - target)  / 2。
        int neg = diff / 2;
        // dp[i][j]:前i个数，和为j的数量。
        int[][] dp = new int[nums.length + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                // 默认不选择 num[i - 1]
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    // dp[i - 1][j]表示不选。
                    // dp[i - 1][j - num]表示选。
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }

        return dp[nums.length][neg];
    }
}
