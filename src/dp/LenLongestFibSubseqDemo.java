package dp;

/**
 * 873. 最长的斐波那契子序列的长度
 * <p>
 * https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 */
// TODO 下次
public class LenLongestFibSubseqDemo {

    public static void main(String[] args) {

    }

    /**
     * dp & 双指针。
     */
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int max = 0;
        // dp[i][j]:数列选择第i和j个数字组成数列的最长长度。
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                // 如果第j个数字和第k个数字加起来恰好跟第i个数字等于，那么表示这三个数字组成一个斐波那契数列。
                if (arr[j] + arr[k] == arr[i]) {
                    // 1. dp[j][k] == 0,那么他们是第一次被选择，那么默认就是3.
                    if (dp[j][k] == 0) {
                        // 注意这里是k 和 i.
                        dp[k][i] = 3;
                    } else {
                        dp[k][i] = Math.max(dp[j][k] + 1, dp[k][i]);
                    }
                    max = Math.max(max, dp[k][i]);
                    k--;
                    j++;
                } else if (arr[j] + arr[k] < arr[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return max;
    }
}
