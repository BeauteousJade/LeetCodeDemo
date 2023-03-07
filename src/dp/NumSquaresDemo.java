package dp;

/**
 * 279. 完全平方数
 * <p>
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class NumSquaresDemo {

    public static void main(String[] args) {
        NumSquaresDemo demo = new NumSquaresDemo();
        System.out.println(demo.numSquares(12));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                // dp[i - j * j]:以j拆分当前数.
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
