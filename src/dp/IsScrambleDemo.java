package dp;

/**
 * 87. 扰乱字符串
 * <p>
 * https://leetcode.cn/problems/scramble-string/
 */
public class IsScrambleDemo {


    public static void main(String[] args) {

    }

    /**
     * 1.状态定义:
     * f[i][j][len]: s1从第i个字符开始,s2从第j个字符开始,长度为len的字符串是否为扰乱字符串。
     * 2.状态转移:
     * f[i][j][len] |=
     * k:range(1, len) ( f[i,j,k] && f[i+k,j+k,len - k] ||  f[i,j + len - k,k] && f[i+k, j, len - k])
     */
    public boolean isScramble(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        int n = s1.length();
        boolean[][][] f = new boolean[n][n][n + 1];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    if (len == 1) {
                        f[i][j][1] = array1[i] == array2[j];
                        continue;
                    }
                    for (int k = 1; k < len; k++) {
                        // a:不交换
                        boolean a = f[i][j][k] && f[i + k][j + k][len - k];
                        // b:前后交换.
                        boolean b = f[i][j + len - k][k] && f[i + k][j][len - k];
                        f[i][j][len] |= a || b;
                    }
                }
            }
        }
        return f[0][0][n];
    }
}
