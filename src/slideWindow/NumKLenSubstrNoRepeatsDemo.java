package slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 1100. 长度为 K 的无重复字符子串
 * <p>
 * https://leetcode.cn/problems/find-k-length-substrings-with-no-repeated-characters/
 */
public class NumKLenSubstrNoRepeatsDemo {

    public static void main(String[] args) {

    }

    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = map.merge(c, 1, Integer::sum);
            while (count > 1) {
                char leftC = s.charAt(left);
                map.merge(leftC, -1, Integer::sum);
                count = map.getOrDefault(c, 0);
                left++;
            }

            if (right - left + 1 >= k) {
                res++;
            }
            right++;
        }
        return res;
    }
}
