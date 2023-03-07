package dp;

/**
 * 265. 粉刷房子 II
 * <p>
 * https://leetcode.cn/problems/paint-house-ii/
 */
public class MinCostDemoV2 {

    public static void main(String[] args) {
        MinCostDemoV2 demo = new MinCostDemoV2();
        int[][] array = {{1, 3}, {2, 4}};
        System.out.println(demo.minCostII(array));
    }

    public int minCostII(int[][] costs) {

        int k = costs[0].length;
        // dp[房子下标][房子颜色]：最小花费。
        int[][] dp = new int[costs.length][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {

            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int m = 0; m < k; m++) {
                    if (m != j) {
                        min = Math.min(min, dp[i - 1][m] + costs[i][j]);
                    }
                }
                dp[i][j] = min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, dp[dp.length - 1][i]);
        }
        return res;
    }
}
