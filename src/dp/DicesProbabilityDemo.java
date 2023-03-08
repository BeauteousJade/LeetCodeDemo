package dp;

/**
 * 剑指 Offer 60. n个骰子的点数
 * <p>
 * https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
 */
public class DicesProbabilityDemo {

    public static void main(String[] args) {

    }

    public double[] dicesProbability(int n) {
        // dp[骰子数量][总和]：该情况下的概率。
        // 总和情况一共有 ：6 * n 种，0不算。
        double[][] dp = new double[n + 1][n * 6 + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1.0 / 6;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j > k) {
                        // k ：当前骰子摇出的数。出现概率是1/6，结合上一个骰子的概率 所以 是 dp[i - 1][j - k] / 6.0。
                        dp[i][j] += dp[i - 1][j - k] / 6.0;
                    }
                }
            }
        }
        // 一共有5 * n + 1个情况，分别是[n, 6 * n]，所以是 6 * n - n + 1 = 5 * n + 1.
        double[] res = new double[5 * n + 1];
        for (int i = 0; i <= 5 * n; i++) {
            res[i] = dp[n][n + i];
        }
        return res;
    }
}
