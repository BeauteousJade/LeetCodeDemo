package dp;

/**
 * 276. 栅栏涂色
 * <p>
 * https://leetcode.cn/problems/paint-fence/?favorite=qg88wci
 */
public class NumWaysDemo {

    public static void main(String[] args) {
        NumWaysDemo demo = new NumWaysDemo();
        System.out.println(demo.numWays(7, 2));
    }

    public int numWays(int n, int k) {
        int[] dp = new int[n];
        dp[0] = k;
        for (int i = 1; i < n; i++) {
            if (i >= 2) {
                // dp[i - 1]:表示跟上一个颜色不同，所以一共有k -1 种选择。
                // dp[i - 2]:表示跟上一个颜色相同，那么上一个跟上上个颜色就相同，所以直接跟上上个相比就行了，一共有k - 1 种选择。
                dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
            } else {
                dp[i] = dp[i - 1] * k;
            }
        }

        return dp[n - 1];
    }
}
