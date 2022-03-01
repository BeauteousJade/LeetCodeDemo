package slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 滑动窗口
 */
public class LengthOfLongestSubstringDemo {
    public static void main(String[] args) {
        LengthOfLongestSubstringDemo demo = new LengthOfLongestSubstringDemo();
        System.out.println(demo.lengthOfLongestSubstring("abc"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int value = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            // badCase
            if (right == s.length() && count == 1) {
                if (right - left > value) {
                    value = right - left;
                }
                break;
            }
            while (count != 1) {
                if (right - left - 1 > value) {
                    value = right - left - 1;
                }
                char d = s.charAt(left);
                left++;
                map.put(d, map.getOrDefault(d, 0) - 1);
                count = map.getOrDefault(c, 0);
            }
        }
        return value;
    }
}
