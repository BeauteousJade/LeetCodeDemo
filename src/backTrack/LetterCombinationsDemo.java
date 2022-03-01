package backTrack;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * <p>
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsDemo {

    public static void main(String[] args) {
        LetterCombinationsDemo demo = new LetterCombinationsDemo();
        System.out.println(demo.letterCombinations("23"));
    }

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        backTrack(digits, map, new StringBuilder());
        return result;
    }


    private void backTrack(String digits, Map<Integer, List<Character>> map, StringBuilder stringBuilder) {
        if (stringBuilder.length() == digits.length()) {
            result.add(stringBuilder.toString());
        } else {
            List<Character> characters = map.get(digits.charAt(stringBuilder.length()) - '0');
            for (int i = 0; i < characters.size(); i++) {
                stringBuilder.append(characters.get(i));
                backTrack(digits, map, stringBuilder);
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            }
        }
    }
}
