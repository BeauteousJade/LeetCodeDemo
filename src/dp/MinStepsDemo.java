package dp;

/**
 * 650. 只有两个键的键盘
 * <p>
 * https://leetcode-cn.com/problems/2-keys-keyboard/
 */
public class MinStepsDemo {

    public static void main(String[] args) {

    }

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    // 1. 先生成j个字符，然后再CV,一共需要i/j步
                    // 比如说i = 4, j = 2, 此时从j到i需要两步，先C，在V
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    // 2. 先生产i / j 个字符，然后再CV， 一共需要j步。
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }
}
