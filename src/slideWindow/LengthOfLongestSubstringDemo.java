package slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 滑动窗口
 */
public class LengthOfLongestSubstringDemo {
    public static void main(String[] args) {
        LengthOfLongestSubstringDemo demo = new LengthOfLongestSubstringDemo();
        System.out.println(demo.lengthOfLongestSubstring("aaabcaa"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int value = 1;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            while ((count != 1 || right == s.length() - 1) && left < right) {
                if (count != 1) {
                    value = Math.max(right - left, value);
                } else {
                    value = Math.max(right - left + 1, value);
                }
                char d = s.charAt(left);
                left++;
                map.put(d, map.getOrDefault(d, 0) - 1);
                count = map.getOrDefault(c, 0);
            }
            right++;
        }
        return value;
    }
}
