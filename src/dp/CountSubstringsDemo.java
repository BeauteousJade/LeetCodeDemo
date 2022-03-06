package dp;

/**
 * 647. 回文子串
 * <p>
 * https://leetcode-cn.com/problems/palindromic-substrings/
 */
// TODO pangbinyu 重点
public class CountSubstringsDemo {

    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        int count = 0;
        final int n = s.length();
        // dp[i][j]：从i到j是否是回文串。
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }
        char[] charArray = s.toCharArray();
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = j - i <= 2 || dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
