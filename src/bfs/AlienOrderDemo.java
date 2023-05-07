package bfs;

import java.util.*;

/**
 * 269. 火星词典
 * <p>
 * https://leetcode.cn/problems/alien-dictionary/
 */
// TODO 下次
public class AlienOrderDemo {

    public static void main(String[] args) {
        AlienOrderDemo demo = new AlienOrderDemo();
        String[] array = {"ab", "adc"};
        System.out.println(demo.alienOrder(array));
    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        boolean[] flags = new boolean[26];
        // 1. 统计所有的字符。
        for (String string : words) {
            char[] array = string.toCharArray();
            for (int i = 0; i < array.length; i++) {
                flags[array[i] - 'a'] = true;
            }
        }
        boolean valid = true;
        //2.前后两个单词构建映射关系
        for (int i = 1; i < words.length && valid; i++) {
            String string1 = words[i - 1];
            String string2 = words[i];
            int index = 0;
            int length = Math.min(string1.length(), string2.length());
            while (index < length) {
                char c1 = string1.charAt(index);
                char c2 = string2.charAt(index);
                if (c1 != c2) {
                    Set<Character> set = map.computeIfAbsent(c2, character -> new HashSet<>());
                    set.add(c1);
                    break;
                }
                index++;
            }
            // 不合法。
            if (index == length && string1.length() > string2.length()) {
                valid = false;
            }
        }
        if (!valid) {
            return "";
        }
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        // 3. 添加入度为0的字符
        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) {
                count++;
                if (!map.containsKey((char) (i + 'a'))) {
                    queue.offer((char) (i + 'a'));
                }
            }
        }
        // 4. 广度搜索。
        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> keySet = map.keySet();
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            for (Character key : keySet) {
                Set<Character> set = map.get(key);
                boolean isRemoved = set.remove(c);
                if (isRemoved && set.isEmpty()) {
                    queue.offer(key);
                }
            }
            stringBuilder.append(c);
        }

        return stringBuilder.length() == count ? stringBuilder.toString() : "";
    }
}
