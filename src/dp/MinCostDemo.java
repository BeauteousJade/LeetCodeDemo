package dp;

/**
 * 256. 粉刷房子
 * <p>
 * https://leetcode.cn/problems/paint-house/
 */
public class MinCostDemo {


    public static void main(String[] args) {
        MinCostDemo demo = new MinCostDemo();
        int[][] array = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(demo.minCost(array));
    }

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int a = costs[0][0];
        int b = costs[0][1];
        int c = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int tempA = a;
            int tempB = b;
            int tempC = c;
            a = Math.min(tempB, tempC) + costs[i][0];
            b = Math.min(tempA, tempC) + costs[i][1];
            c = Math.min(tempA, tempB) + costs[i][2];
        }

        return Math.min(a, Math.min(b, c));
    }

    public int minCostV2(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        // dp[房子下标][房子颜色]：最小花费。
        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        return Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
    }
}
