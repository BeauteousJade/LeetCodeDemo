package dp;

/**
 * 714. 买卖股票的最佳时机含手续费
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class MaxProfitIncludeFeeDemo {

    public static void main(String[] args) {
        MaxProfitIncludeFeeDemo demo = new MaxProfitIncludeFeeDemo();
        System.out.println(demo.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }


    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
