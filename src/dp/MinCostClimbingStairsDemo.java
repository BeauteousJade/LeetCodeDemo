package dp;

/**
 * 746. 使用最小花费爬楼梯
 * <p>
 * https://leetcode.cn/problems/min-cost-climbing-stairs/
 */
// TODO 下次
public class MinCostClimbingStairsDemo {

    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
