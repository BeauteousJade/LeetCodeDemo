package dp;

/**
 * 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * <p>
 * 三维DP：背包问题。
 * <p>
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 */
// TODO 下次
public class FindMaxFormDemo {

    public static void main(String[] args) {

        FindMaxFormDemo demo = new FindMaxFormDemo();
        String[] array = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(demo.findMaxForm(array, m, n));
    }

    public int findMaxForm(String[] strs, int m, int n) {

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {
            int[] count = getCount(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= count[0] && k >= count[1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private int[] getCount(String string) {
        int[] counts = new int[2];
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            counts[charArray[i] - '0']++;
        }
        return counts;
    }
}
