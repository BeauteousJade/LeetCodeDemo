package dp;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class MaxProfitIncludeFreezeDemo {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        // 持有股票
        dp[0][0] = -prices[0];
        // 不持有股票，且处于冷冻期。
        dp[0][1] = 0;
        // 不持有股票，且不处于冷冻期。
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 当前持有股票，一个是前一天继承下来的，第二个是前一天不是冷冻期，今天买入。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 当前处于冷冻期，那就是把前一天买入的股票卖出。
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 当前不处于冷冻期，一个是前一天是冷冻期，第二是前一天不是冷冻期。
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
