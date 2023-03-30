package dp;

/**
 * 471. 编码最短长度的字符串
 * <p>
 * https://leetcode.cn/problems/encode-string-with-shortest-length/
 */
public class EncodeDemo {

    public static void main(String[] args) {
        EncodeDemo demo = new EncodeDemo();
        System.out.println(demo.encode("aaa"));
        System.out.println(demo.encode("aaaaa"));
        System.out.println(demo.encode("aabcaabcd"));
    }

    String[][] dp;

    public String encode(String s) {
        int n = s.length();
        // dp[i][j]:表示从i到j的子串所能组成的最短编码。
        dp = new String[n][n];
        // 先要遍历短的子串，因为在dp计算的时候会拆子串。
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = minRepeatSubstring(s, i, j);
                if (len > 4) {
                    for (int k = i; k < j; k++) {
                        // 这里拆子串。
                        if (dp[i][j].length() > (dp[i][k].length() + dp[k + 1][j].length())) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    private String minRepeatSubstring(String s, int i, int j) {
        if (i == j + 1) {
            return "";
        }
        String newS = s.substring(i, j + 1);
        if (newS.length() <= 4) {
            return newS;
        }
        // 判断newString是否以重复字串构成。
        int index = (newS + newS).indexOf(newS, 1);
        // 如果index != newS.length()，表示newS内部是由重复字串构造成。
        if (index != newS.length()) {
            int count = newS.length() / index;
            // 注意这里不能从源字符串上截取，因为还有嵌套的情况，dp[i][i + index - 1]可能已经压缩过了。
            return count + "[" + dp[i][i + index - 1] + "]";

        }

        return s;
    }
}
