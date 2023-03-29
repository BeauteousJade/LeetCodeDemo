package dp;

/**
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/
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
                // 1.当前减去j，那么对应的结果可能是 j * dp[i - j](非第一刀)，可能是j * (i - j)(第一刀)
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
