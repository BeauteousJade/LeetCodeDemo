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
     * https://leetcode.cn/problems/regular-expression-matching/solution/by-flix-musv/
     *
     */
    public boolean isMatch(String s, String p) {
        // dp[i][j]：s的前i个字符是否与p的前j个字符匹配。
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                // 按照'*'的作用，'*'不会出现在第一位。
                if (p.charAt(j - 1) == '*') {
                    // p 前一个字符，跟s当前字符匹配
                    if (match(s, p, i, j - 1)) {
                        // s:ab和t:ab
                        // dp[i][j - 2]: * 重复0次， 消掉前面一个字符，把前面那个字符给消掉。即使匹配也可以消掉。
                        // dp[i - 1][j]：* 重复n次。
                        // （1）dp[i][j]= (dp[i][j−2]) or (dp[i−1][j−2]&s[i]=p[j−1] or dp[i−2][j−2]&s[i−1,i]=p[j−1]or...or dp[i−k][j−2]&s[i−k+1,...,i]=p[j−1])
                        // （2）dp[i−1][j] = (dp[i−1][j−2]) or (dp[i−2][j−2]&s[i−1]=p[j−1]or...or dp[i−k][j−2]&s[i−k+1,...,i−1]=p[j−1])
                        //  将(2) 带入(1)中，得到：
                        //  dp[i][j] = dp[i][j−2]or { dp[i−1][j ]& s[i]=p[j−1] }
                        //  由于s[i]=p[j−1]已经匹配，所以简化为：
                        //  dp[i][j] = dp[i][j−2] or dp[i−1][j]
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
        if (i == 0 || j == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
