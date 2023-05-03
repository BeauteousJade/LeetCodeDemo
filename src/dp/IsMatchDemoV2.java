package dp;

/**
 * 44. 通配符匹配
 * <p>
 * https://leetcode.cn/problems/wildcard-matching/
 */
public class IsMatchDemoV2 {

    public static void main(String[] args) {

    }


    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j]:m的前i个字符跟n的前j个字符是否匹配.
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 初始第一行
        for (int i = 1; i <= n; ++i) {
            // 前置* 默认都匹配。
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char c1 = s.charAt(i - 1);
                char c2 = p.charAt(j - 1);
                if (c2 == '*') {
                    // dp[i][j - 1]: 匹配空字符
                    // dp[i - 1][j]: 匹配多个字符
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (match(c1, c2)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    private boolean match(char c1, char c2) {
        if (c2 == '?') {
            return true;
        }
        return c1 == c2;
    }
}
