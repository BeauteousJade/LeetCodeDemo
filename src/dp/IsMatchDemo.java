package dp;

/**
 * 10. 正则表达式匹配
 * <p>
 * https://leetcode.cn/problems/regular-expression-matching/?favorite=2cktkvj
 */
public class IsMatchDemo {

    public static void main(String[] args) {
        IsMatchDemo demo = new IsMatchDemo();
        System.out.println(demo.isMatch("aab", "c*a*b"));
    }

    /**
     * https://leetcode.cn/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-chen-wei-6h9ap/
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    // p 前一个字符，跟s当前字符匹配
                    if (match(s, p, i, j - 1)) {
                        // s:ab和t:ab
                        // dp[i][j - 2]: * 重复0次， 消掉前面一个字符，把前面那个字符给消掉。即使匹配也可以消掉。
                        // dp[i - 1][j]：* 重复n次。
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        //对应位置上不匹配，那么就 * 重复0， 消掉前面一个字符。
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }


    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
