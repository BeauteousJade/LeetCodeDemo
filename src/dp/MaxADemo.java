package dp;

/**
 * 651. 4键键盘
 * <p>
 * https://leetcode-cn.com/problems/4-keys-keyboard/
 */
// TODO pangbingyu03
public class MaxADemo {

    public static void main(String[] args) {

    }

    public int maxA(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++){
            // 默认是上一步直接输入一个A
            dp[i] = dp[i - 1] + 1;
            for (int k = 0; k < i - 1; k++) {
                // 当到k步时，先ctrl A, ctrl C, ctrl V
                // 一共会经历 i - k - 2次ctrl V，所以，总数是dp[k] * (i - k - 1）
                dp[i] = Math.max(dp[i], dp[k] * (i - k - 1));
            }
        }
        return dp[n];
    }
}
