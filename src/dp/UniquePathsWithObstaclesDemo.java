package dp;

/**
 * 63. 不同路径 II
 * <p>
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsWithObstaclesDemo {

    public static void main(String[] args) {
        UniquePathsWithObstaclesDemo demo = new UniquePathsWithObstaclesDemo();
        int[][] array = {{0, 1}, {0, 0}};
        System.out.println(demo.uniquePathsWithObstacles(array));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        boolean isBlock = false;
        for (int i = 0; i < obstacleGrid.length; i++) {
            isBlock = isBlock || obstacleGrid[i][0] == 1;
            dp[i][0] = isBlock ? 0 : 1;
        }
        isBlock = false;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            isBlock = isBlock || obstacleGrid[0][i] == 1;
            dp[0][i] = isBlock ? 0 : 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    /**
     * 压缩空间
     */
    public int uniquePathsWithObstaclesV2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }
}
