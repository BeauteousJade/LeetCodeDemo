package bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * <p>
 * https://leetcode.cn/problems/aseY1I/
 */
public class MaxProductDemo {

    public static void main(String[] args) {

    }

    public int maxProduct(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : words) {
            map.put(string, help(string));
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int num = map.get(words[i]);
                int num2 = map.get(words[j]);
                if ((num & num2) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private int help(String string) {
        int res = 0;
        for (int i = 0; i < string.length(); i++) {
            int c = string.charAt(i) - 'a';
            res = res | (1 << c);
        }
        return res;
    }
}
