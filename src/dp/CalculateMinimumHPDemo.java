package dp;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 * <p>
 * https://leetcode.cn/problems/dungeon-game/
 */
// TODO 下次
public class CalculateMinimumHPDemo {

    public static void main(String[] args) {

    }

    /**
     * 正向dp无后效性,所以需要反向dp.
     * <p>
     * https://leetcode.cn/problems/dungeon-game/solution/di-xia-cheng-you-xi-by-leetcode-solution/
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        // 数组是从[n - 1][m - 1] 开始计算, 第一次计算需要[n][m - 1] 和[n - 1][m]这两个值,默认是MAX_VALUE,计算会不对.所以初始为1.
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }


}
