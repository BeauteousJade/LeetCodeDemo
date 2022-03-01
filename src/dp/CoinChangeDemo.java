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
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + dp[coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
