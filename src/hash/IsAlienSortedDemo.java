package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. 验证外星语词典
 * <p>
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 */
public class IsAlienSortedDemo {

    public static void main(String[] args) {

    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String preWord = words[i - 1];
            String word = words[i];
            if (preWord.equals(word)) {
                continue;
            }
            int minLength = Math.min(preWord.length(), word.length());
            boolean isLabel = false;
            for (int j = 0; j < minLength; j++) {
                int preIndex = map.getOrDefault(preWord.charAt(j), 0);
                int index = map.getOrDefault(word.charAt(j), 0);
                if (preIndex < index) {
                    isLabel = true;
                    break;
                }
                if (preIndex > index) {
                    return false;
                }
            }
            if (preWord.length() > minLength && !isLabel) {
                return false;
            }
        }
        return true;
    }
}
