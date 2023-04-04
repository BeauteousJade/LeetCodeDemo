package dp;

/**
 * 1143. 最长公共子序列
 * <p>
 * https://leetcode.cn/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequenceDemo {

    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // dp[i][j]:text1的前i个字符跟text2的前j个字符的最长公共子序列。
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
