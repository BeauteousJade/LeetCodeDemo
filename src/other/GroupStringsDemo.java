package other;

import java.util.*;

/**
 * 249. 移位字符串分组
 * <p>
 * https://leetcode.cn/problems/group-shifted-strings/
 */
public class GroupStringsDemo {

    public static void main(String[] args) {
        GroupStringsDemo demo = new GroupStringsDemo();
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(demo.groupStrings(strings));
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            String key = getKey(string);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(string);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            res.add(list);
        }
        return res;
    }


    private String getKey(String string) {
        char[] chars = string.toCharArray();
        char c = chars[0];
        int count = c - 'a';
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] - 'a') >= count) {
                chars[i] = (char) (chars[i] - count);
            } else {
                chars[i] = (char) (chars[i] + 26 - count);
            }
        }
        return new String(chars);
    }
}
