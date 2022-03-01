package slideWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 567. 字符串的排列
 * <p>
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class CheckInclusionDemo {

    public static void main(String[] args) {
        CheckInclusionDemo demo = new CheckInclusionDemo();
        System.out.println(demo.checkInclusion("abd", "eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        char[] charArray = s1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            need.put(charArray[i], need.getOrDefault(charArray[i], 0) + 1);
        }
        int left = 0;
        int right = 0;
        int validCount = 0;
        charArray = s2.toCharArray();
        while (right < s2.length()) {
            char c = charArray[right];
            if (need.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (Objects.equals(map.get(c), need.get(c))) {
                    validCount++;
                }
            }
            while (validCount == need.size()) {
                if (right - left + 1 == s1.length()) {
                    return true;
                }
                c = charArray[left];
                if (need.containsKey(c)) {
                    if (Objects.equals(map.get(c), need.get(c))) {
                        validCount--;
                    }
                    map.put(c, map.getOrDefault(c, 0) - 1);
                }
                left++;
            }
            right++;
        }
        return false;
    }
}
