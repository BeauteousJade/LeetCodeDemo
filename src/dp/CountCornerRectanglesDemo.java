package dp;

/**
 * 750. 角矩形的数量 -- dp
 * <p>
 * https://leetcode.cn/problems/number-of-corner-rectangles/
 */
public class CountCornerRectanglesDemo {


    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(new CountCornerRectanglesDemo().countCornerRectangles(grid));
    }

    public int countCornerRectangles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        // dp[i][j]:表示第i列和第j列同时为1的次数。
        int[][] dp = new int[col][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int k = j + 1; k < col; k++) {

                    if (grid[i][k] == 1) {
                        // 到这里，表示当前行，第j列和第k列同时为1，那么此时有可能会构成角矩形。
                        // 如果是第i列和第j列第一次同时为1，那么这里加上的是0，因此不会角矩形的数量不会新增。
                        // 当不是第一次同时为1，那么此时就构成角矩形，数量就是 dp[j][k]
                        res += dp[j][k];
                        dp[j][k]++;
                    }
                }
            }
        }

        return res;
    }
}
