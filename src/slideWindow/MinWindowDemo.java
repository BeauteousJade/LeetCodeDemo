package slideWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 76. 最小覆盖子串
 * <p>
 * https://leetcode.cn/problems/minimum-window-substring/?favorite=2cktkvj
 */
public class MinWindowDemo {

    public static void main(String[] args) {
        MinWindowDemo demo = new MinWindowDemo();
        String s = demo.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    public String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int validCount = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (Objects.equals(map.get(c), need.get(c))) {
                    validCount++;
                }
            }
            while (validCount == need.size()) {
                if (right - left + 1 < length) {
                    length = right - left + 1;
                    start = left;
                }
                char c1 = s.charAt(left++);
                // 注意这里。只有map中有，才更新。
                if (map.containsKey(c1)) {
                    if (Objects.equals(map.get(c1), need.get(c1))) {
                        validCount--;
                    }
                    map.put(c1, map.getOrDefault(c1, 0) - 1);
                }
            }
            right++;
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
