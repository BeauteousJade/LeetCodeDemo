package dp;

import java.util.Arrays;

/**
 * 132. 分割回文串 II
 * <p>
 * https://leetcode.cn/problems/palindrome-partitioning-ii/
 */
public class MinCutDemo {

    public static void main(String[] args) {

    }

    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        // 1. 先记录下哪些是回文串。
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[j][i] = false;
                } else {
                    dp[j][i] = i - j <= 2 || dp[j + 1][i - 1];
                }
            }
        }

        int[] dp1 = new int[s.length()];
        Arrays.fill(dp1, Integer.MAX_VALUE);
        // 2. 计算最小分割。
        for (int i = 0; i < s.length(); i++) {
            // 如果0-i是回测串，那么不需要切割。
            if (dp[0][i]) {
                dp1[i] = 0;
            } else {
                // 当前从j切到i，计算最小。
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        dp1[i] = Math.min(dp1[i], dp1[j] + 1);
                    }
                }
            }
        }
        return dp1[s.length() - 1];
    }
}
