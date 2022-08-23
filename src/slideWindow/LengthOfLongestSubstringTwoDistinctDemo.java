package slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 159. 至多包含两个不同字符的最长子串
 * <p>
 * https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/
 */
public class LengthOfLongestSubstringTwoDistinctDemo {

    public static void main(String[] args) {
        LengthOfLongestSubstringTwoDistinctDemo demo = new LengthOfLongestSubstringTwoDistinctDemo();
        System.out.println(demo.lengthOfLongestSubstringTwoDistinct("aadddcccceeeeee"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;
        int value = 1;
        while (right < s.length()) {
            int count = map.getOrDefault(charArray[right], 0) + 1;
            map.put(charArray[right], count);
            while ((map.size() > 2 || right == s.length() - 1) && left < right) {
                // 如果是最后一位，需要计算；如果是不是最后一位，不需要计算。
                value = Math.max(right + (map.size() > 2 ? 0 : 1) - left, value);
                int newCount = map.getOrDefault(charArray[left], 0) - 1;
                if (newCount <= 0) {
                    map.remove(charArray[left]);
                } else {
                    map.put(charArray[left], newCount);
                }
                left++;
            }
            right++;
        }
        return value;
    }

}
