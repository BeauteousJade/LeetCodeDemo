package dp;

import java.util.Map;

/**
 * 361. 轰炸敌人
 * <p>
 * https://leetcode.cn/problems/bomb-enemy/submissions/
 */
public class MaxKilledEnemiesDemo {


    public static void main(String[] args) {
        MaxKilledEnemiesDemo demo = new MaxKilledEnemiesDemo();
        System.out.println(demo.maxKilledEnemies(new char[][]{{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}}));
    }


    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int pre = 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            pre = 0;
            // 从左往右遍历，计算当前点能炸死左侧的敌人个数。
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'E') {
                    pre++;
                } else if (grid[i][j] == 'W') {
                    pre = 0;
                } else {
                    dp[i][j] += pre;
                    res = Math.max(res, dp[i][j]);
                }
            }
            pre = 0;

            // 从右往左遍历，计算当前点能炸死右侧的敌人个数。
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'E') {
                    pre++;
                } else if (grid[i][j] == 'W') {
                    pre = 0;
                } else {
                    dp[i][j] += pre;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            pre = 0;
            // 从上到下遍历，计算当前点能炸死左侧的敌人个数。
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'E') {
                    pre++;
                } else if (grid[i][j] == 'W') {
                    pre = 0;
                } else {
                    dp[i][j] += pre;
                    res = Math.max(res, dp[i][j]);
                }
            }

            pre = 0;

            // 从下到上遍历，计算当前点能炸死右侧的敌人个数。
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 'E') {
                    pre++;
                } else if (grid[i][j] == 'W') {
                    pre = 0;
                } else {
                    dp[i][j] += pre;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }


        return res;
    }
}
