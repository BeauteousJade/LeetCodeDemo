package dp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 120. 三角形最小路径和
 * <p>
 * https://leetcode.cn/problems/triangle/
 */
public class MinimumTotalDemo {

    public static void main(String[] args) {
        int[][] array = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> list = Arrays.stream(array).map(ints -> Arrays.stream(ints).boxed().toList()).toList();
        MinimumTotalDemo demo = new MinimumTotalDemo();
        System.out.println(demo.minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            // 第一个只从上一个继承。
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            // 每行最后一个，只从左上一个继承。
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = dp[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        return minTotal;
    }
}
