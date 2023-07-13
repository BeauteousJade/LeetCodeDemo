package dp;

/**
 * 338. 比特位计数
 * <p>
 * https://leetcode-cn.com/problems/counting-bits/
 */
// TODO 下次
public class CountBitsDemo {

    public static void main(String[] args) {

    }

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
