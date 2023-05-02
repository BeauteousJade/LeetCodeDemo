package dp;

/**
 * 97. 交错字符串
 * <p>
 * https://leetcode.cn/problems/interleaving-string/
 */
// TODO 下次
public class IsInterleaveDemo {

    public static void main(String[] args) {

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || s1.charAt(i - 1) == s3.charAt(p) && dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || s2.charAt(j - 1) == s3.charAt(p) && dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
