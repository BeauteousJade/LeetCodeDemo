package dp;

/**
 * 123. 买卖股票的最佳时机 III
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class MaxProfitDemoV3 {

    public static void main(String[] args) {
        MaxProfitDemoV3 demo = new MaxProfitDemoV3();
        System.out.println(demo.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        // dp[天数][是否持股][卖出次数]
        int[][][] dp = new int[n][2][3];
        // 第一天不持股
        dp[0][0][0] = 0;
        // 第一天持股
        dp[0][1][0] = -prices[0];
        int min = Integer.MIN_VALUE / 2;
        // 卖出一次，非法
        dp[0][0][1] = min;
        dp[0][1][1] = min;
        // 卖出两次，非法
        dp[0][0][2] = min;
        dp[0][1][2] = min;

        for (int i = 1; i < n; i++) {
            // 卖出零次
            dp[i][0][0] = 0;
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            // 卖出一次
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            // 卖出两次
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][2] = min;
        }

        return Math.max(0, Math.max(dp[n - 1][0][2], dp[n - 1][0][1]));
    }
}
