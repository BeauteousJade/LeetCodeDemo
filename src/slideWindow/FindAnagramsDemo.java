package slideWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * <p>
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAnagramsDemo {

    public static void main(String[] args) {
        FindAnagramsDemo demo = new FindAnagramsDemo();
        System.out.println(demo.findAnagrams("abab", "abc"));
    }


    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = p.toCharArray();
        for (char c : charArray) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        charArray = s.toCharArray();
        int validCount = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            char c = charArray[right];
            if (need.containsKey(c)) {
                int newCount = map.getOrDefault(c, 0) + 1;
                map.put(c, newCount);
                if (need.get(c) == newCount) {
                    validCount++;
                }
            }
            while (validCount == need.size()) {
                if (right - left + 1 == p.length()) {
                    list.add(left);
                }
                c = charArray[left++];
                if (need.containsKey(c)) {
                    int newCount = map.getOrDefault(c, 0);
                    if (need.get(c) == newCount) {
                        validCount--;
                    }
                    map.put(c, newCount - 1);
                }
            }
            right++;
        }
        return list;
    }
}
