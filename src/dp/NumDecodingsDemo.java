package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 91. 解码方法
 * <p>
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodingsDemo {

    public static void main(String[] args) {
        NumDecodingsDemo demo = new NumDecodingsDemo();
        System.out.println(demo.numDecodings("1123"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || (s.length() == 1 && s.charAt(0) == '0')) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }


        Map<String, Boolean> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(String.valueOf(i), true);
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {

            char c = s.charAt(i - 1);
            if (c != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1) {
                String substring = s.substring(i - 2, i);
                if (map.containsKey(substring)) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}
