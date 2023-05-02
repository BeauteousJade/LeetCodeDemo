package dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChangeDemo {

    public static void main(String[] args) {
        CoinChangeDemo demo = new CoinChangeDemo();
        System.out.println(demo.coinChange(new int[]{2, 3, 5}, 1));
    }

    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && coins[i - coins[j]] != max) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
