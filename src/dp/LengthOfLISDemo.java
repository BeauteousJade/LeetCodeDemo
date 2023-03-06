package dp;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * <p>
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LengthOfLISDemo {

    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
