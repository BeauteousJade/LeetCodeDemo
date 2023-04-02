package dp;

/**
 * 312. 戳气球
 * <p>
 * https://leetcode.cn/problems/burst-balloons/
 */
// TODO 重点
public class MaxCoinsDemo {


    public static void main(String[] args) {
    }

    public int maxCoins(int[] nums) {
        int[][] rec = new int[nums.length + 2][nums.length + 2];
        int[] val = new int[nums.length + 2];
        val[0] = val[nums.length + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            val[i] = nums[i - 1];
        }

        /**
         *
         * dp版本代码，最外层的循环，i为什么是n-1 -> 0，而不能反过来？
         * (i,j) 0 1  2   3   4   ...   n-2   n-1   n   n+1
         * 0     0 1  2   3   4   ...                   n+1
         * 1       1  2   3   4   ...                   n+1
         * 2          2   3   4   ...                   n+1
         * 3              3   4   ...                   n+1
         * 4                  4                         n+1
         * .                      .                     .
         * .                         .                  .
         * n-2                          n-2   n-1   n   n+1
         * n-1                                n-1   n   n+1
         *
         * 须从下往上算，即先算rec[n-1][n+1]。
         * 根据递推关系，算rec[i][j]时依赖的rec[i][k]和rec[k][j]，其中i<k<j。
         * 1、如果从上往下计算，依赖的rec[k][j]根本就还未算出（k比i大），比如算rec[0][3]时，依赖的dp[1][3]还是个未知数
         * 2、从下往上就不一样，算rec[i][j]时，依赖的rec[i][k]，位于同一行左侧，已计算过；依赖的dp[k][j]，因为k>i，位于更下面的行，也已计算过。
         */
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 2; j <= nums.length + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][nums.length + 1];
    }
}
