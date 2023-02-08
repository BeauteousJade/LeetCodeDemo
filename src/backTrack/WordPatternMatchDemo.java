package backTrack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 291. 单词规律 II
 * <p>
 * https://leetcode.cn/problems/word-pattern-ii/?favorite=qg88wci
 */
public class WordPatternMatchDemo {

    private boolean isRes;

    public static void main(String[] args) {
        WordPatternMatchDemo demo = new WordPatternMatchDemo();
//        System.out.println(demo.wordPatternMatch("sucks", "teezmmmmteez"));
        System.out.println(demo.wordPatternMatch("d", "e"));
    }

    public boolean wordPatternMatch(String pattern, String s) {

        Map<Character, String> map = new HashMap<>();
        dfs(map, pattern.toCharArray(), 0, s, 0);
        return isRes;
    }


    private void dfs(Map<Character, String> map, char[] array1, int startIndex1, String string, int startIndex2) {
        if (isRes) {
            return;
        }
        if (startIndex1 == array1.length) {
            isRes = startIndex2 == string.length();
        } else {
            char c = array1[startIndex1];
            String s = map.get(c);
            if (s != null && string.length() - startIndex2 >= s.length()) {
                String subString = string.substring(startIndex2, startIndex2 + s.length());
                if (s.equals(subString)) {
                    dfs(map, array1, startIndex1 + 1, string, startIndex2 + s.length());
                }
            } else if (s == null) {
                for (int i = startIndex2; i < string.length(); i++) {
                    String subString = string.substring(startIndex2, i + 1);
                    if (!check(subString, map)) {
                        continue;
                    }
                    map.put(c, subString);
                    dfs(map, array1, startIndex1 + 1, string, i + 1);
                    map.remove(c);
                }
            }
        }
    }

    private boolean check(String string, Map<Character, String> map) {
        Set<Character> keySet = map.keySet();
        for (Character key : keySet) {
            if (map.get(key).equals(string)) {
                return false;
            }
        }
        return true;
    }
}
