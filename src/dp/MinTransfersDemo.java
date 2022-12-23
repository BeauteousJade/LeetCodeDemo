package dp;

/**
 * 465. 最优账单平衡
 * <p>
 * https://leetcode.cn/problems/optimal-account-balancing/
 * <p>
 * https://www.bilibili.com/video/BV1sT411g7Fq/?t=22m25s&vd_source=2a8b072b61f2de3b5b597fbf5c040a30
 */
public class MinTransfersDemo {

    public static void main(String[] args) {

        System.out.println((3 >> 0) & 1);
    }

    public int minTransfers(int[][] transactions) {
        final int n = 12;
        int[] cnt = new int[n];
        for (int[] d : transactions) {
            cnt[d[0]] -= d[2];
            cnt[d[1]] += d[2];
        }
        final int m = 1 << n;
        int[] dp = new int[m];
        // 拆子集
        for (int i = 1; i < m; ++i) {
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                // 如果当前bit位上等于1，那么表示子集里面包含当前位置上数字。
                if (((i >> j) & 1) > 0) {
                    sum += cnt[j];
                }
            }
            // 如果当前子集和不等于0，表示是非法子集。
            if (sum != 0) {
                dp[i] = Integer.MAX_VALUE / 2; // 防止溢出
            } else {
                // 最大是当前子集个数 -1.
                dp[i] = Integer.bitCount(i) - 1;
                // 根据i为总集合,拆分出子集j和其补集i ^ j，计算出以i为总集合的最小次数。--拆分子问题。
                for (int j = (i - 1) & i; j > 0; j = (j - 1) & i) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i ^ j]);
                }
            }
        }
        return dp[m - 1];
    }
}
