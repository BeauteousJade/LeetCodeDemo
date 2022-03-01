package dp;

/**
 * 188. 买卖股票的最佳时机 IV
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class MaxProfitDemoV4 {

    public static void main(String[] args) {
        MaxProfitDemoV4 demo = new MaxProfitDemoV4();
        System.out.println(demo.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // dp[天数][是否持股][卖出次数]
        int[][][] dp = new int[n][2][k + 1];
        int min = Integer.MIN_VALUE / 2;
        for (int i = 0; i <= k; i++) {
            if (i == 0) {
                dp[0][0][0] = 0;
                dp[0][1][0] = -prices[0];
            } else {
                dp[0][0][i] = min;
                dp[0][1][i] = min;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][0][0] = 0;
                    dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
                } else if (j != k) {
                    dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);
                } else {
                    dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
                    dp[i][1][j] = min;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, dp[n - 1][0][i]);
        }
        return res;
    }
}
