package dp;

/**
 * 377. 组合总和 Ⅳ
 * <p>
 * https://leetcode.cn/problems/combination-sum-iv/
 */
public class CombinationSum4Demo {

    public static void main(String[] args) {

    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
