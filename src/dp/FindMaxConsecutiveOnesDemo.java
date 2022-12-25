package dp;

/**
 * 487. 最大连续1的个数 II
 * <p>
 * https://leetcode.cn/problems/max-consecutive-ones-ii/
 */
public class FindMaxConsecutiveOnesDemo {


    public static void main(String[] args) {
        FindMaxConsecutiveOnesDemo demo = new FindMaxConsecutiveOnesDemo();
        System.out.println(demo.findMaxConsecutiveOnesV2(new int[]{1, 1, 0, 1, 0}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                prefix[i] = i > 0 ? prefix[i - 1] + 1 : 1;
            }
            int j = n - i - 1;
            if (nums[j] == 1) {
                suffix[j] = j < n - 1 ? suffix[j + 1] + 1 : 1;
            }
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (nums[i] == 0) {
                count = 1;
                if (i > 0) {
                    count += prefix[i - 1];
                }
                if (i < n - 1) {
                    count += suffix[i + 1];
                }
            } else {
                count = prefix[i];
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public int findMaxConsecutiveOnesV2(int[] nums) {
        int n = nums.length;
        // 0: 未变化，连续1的最大个数.
        // 1: 已变化，连续1的最大个数。
        int[][] dp = new int[n][2];
        if (nums[0] == 1) {
            dp[0][1] = 1;
            dp[0][0] = 1;
        } else {
            dp[0][1] = 1; // 这里需要变化，所以只有dp[0][1]才为1.
        }
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 1) {
                dp[i][1] = dp[i - 1][1] + 1;
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 0;
                // 当前为0，需要变化，所以需要上一次没有变化的次数。
                dp[i][1] = dp[i - 1][0] + 1;
            }
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }

    public int findMaxConsecutiveOnesV3(int[] nums) {
        int n = nums.length;
        int dp0 = 0;
        int dp1 = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                dp0++;
                dp1++;
            } else {
                dp1 = dp0 + 1;
                dp0 = 0;
            }
            ans = Math.max(ans, Math.max(dp0, dp1));
        }
        return ans;
    }
}
