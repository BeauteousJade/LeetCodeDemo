package other;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <p>
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagramsDemo {

    public static void main(String[] args) {
        GroupAnagramsDemo demo = new GroupAnagramsDemo();
        System.out.println(demo.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String string : strs) {
            String key = getKey(string);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(string);
            if (!res.contains(list)) {
                res.add(list);
            }
        }
        return res;
    }


    private String getKey(String string) {
        int[] array = new int[26];
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            array[charArray[i] - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                stringBuilder.append(i + 'a');
                stringBuilder.append(array[i]);
            }
        }
        return stringBuilder.toString();
    }
}
