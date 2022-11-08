package slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. 至多包含 K 个不同字符的最长子串
 * <p>
 * https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/?favorite=qg88wci
 */
public class LengthOfLongestSubstringKDistinctDemo {

    public static void main(String[] args) {
        LengthOfLongestSubstringKDistinctDemo demo = new LengthOfLongestSubstringKDistinctDemo();
        System.out.println(demo.lengthOfLongestSubstringKDistinct("aa", 1));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;
        int res = 1;
        while (right < s.length()) {
            char c = charArray[right];
            map.put(c, map.getOrDefault(c, 0) + 1);
            while ((map.size() > k || right == s.length() - 1) && left < right) {
                res = Math.max(res, right + (map.size() > k ? 0 : 1) - left);
                char leftC = charArray[left++];
                int count = map.get(leftC) - 1;
                if (count <= 0) {
                    map.remove(leftC);
                } else {
                    map.put(leftC, count);
                }
            }
            right++;
        }
        return res;
    }
}
