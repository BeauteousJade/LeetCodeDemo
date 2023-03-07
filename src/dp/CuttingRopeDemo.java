package dp;

/**
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * https://leetcode.cn/submissions/detail/410096168/
 */
public class CuttingRopeDemo {

    public static void main(String[] args) {

    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
