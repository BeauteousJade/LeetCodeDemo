package dfs;

/**
 * 562. 矩阵中最长的连续1线段
 * <p>
 * https://leetcode.cn/problems/longest-line-of-consecutive-one-in-matrix/
 */
public class LongestLineDemo {

    public static void main(String[] args) {
        LongestLineDemo demo = new LongestLineDemo();
        int[][] array = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}};
//        int[][] array = {{1, 1, 1, 1}, {0, 1, 1, 0}, {0, 0, 0, 1}};
//        int[][] array = {
//                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
//                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
//                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
//                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
//                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
//                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
//                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
//                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
//                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
//                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
//        };
        System.out.println(demo.longestLine(array));
    }

    public int longestLine(int[][] mat) {
        // 0：垂直
        // 1：水平
        // 2: 对角
        // 3：反对角线
        int[][][] dp = new int[mat.length][mat[0].length][4];
        int res = 0;


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        if (k == 0) {
                            dp[i][j][k] = i > 0 ? dp[i - 1][j][k] + 1 : 1;
                        } else if (k == 1) {
                            dp[i][j][k] = j != 0 ? dp[i][j - 1][k] + 1 : 1;
                        } else if (k == 2) {
                            dp[i][j][k] = i > 0 && j > 0 ? dp[i - 1][j - 1][k] + 1 : 1;
                        } else {
                            dp[i][j][k] = i > 0 && j < mat[0].length - 1 ? dp[i - 1][j + 1][k] + 1 : 1;
                        }
                        res = Math.max(res, dp[i][j][k]);
                    }
                }
            }
        }
        return res;
    }
}
