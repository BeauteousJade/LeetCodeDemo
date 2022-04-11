package dp;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
// TODO 下次
public class MaxProfitDemoV2 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // dp[i][0]:不持有股票
        // dp[i][1]:持有股票
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
