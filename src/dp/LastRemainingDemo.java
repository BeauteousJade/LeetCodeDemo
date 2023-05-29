package dp;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * <p>
 * 约瑟夫环问题
 * <p>
 * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
// TODO 下次
public class LastRemainingDemo {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/jian-zhi-offer-62-yuan-quan-zhong-zui-ho-dcow/
     */
    public int lastRemaining(int n, int m) {
        // dp[数字的数量]：在指定数量的数字下，最后的结果。
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + m) % i;
        }
        return dp[n];
    }

    /**
     * dp 压缩版。
     */
    public int lastRemainingV2(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
