package bfs;

import java.util.*;

/**
 * 127. 单词接龙
 * <p>
 * https://leetcode.cn/problems/word-ladder/
 */
public class LadderLengthDemo {

    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        wordList = new ArrayList<>(wordList);
        boolean isAdd = wordList.contains(beginWord);
        // 建立起连接关系。
        for (int i = 0; i < wordList.size() - 1; i++) {
            if (isValid(beginWord, wordList.get(i)) && !isAdd) {
                map.computeIfAbsent(beginWord, s -> new ArrayList<>()).add(wordList.get(i));
                map.computeIfAbsent(wordList.get(i), s -> new ArrayList<>()).add(beginWord);
            }
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isValid(wordList.get(i), wordList.get(j))) {
                    map.computeIfAbsent(wordList.get(i), s -> new ArrayList<>()).add(wordList.get(j));
                    map.computeIfAbsent(wordList.get(j), s -> new ArrayList<>()).add(wordList.get(i));
                }
            }
        }
        // 第一个单词分为在字典中，和不在字典中两种情况。需要单独处理。
        if (isValid(beginWord, wordList.get(wordList.size() - 1)) && !isAdd) {
            map.computeIfAbsent(beginWord, s -> new ArrayList<>()).add(wordList.get(wordList.size() - 1));
            map.computeIfAbsent(wordList.get(wordList.size() - 1), s -> new ArrayList<>()).add(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map1 = new HashMap<>();
        map1.put(beginWord, 1);
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            List<String> nextStrings = map.getOrDefault(s, Collections.emptyList());
            int distance = map1.getOrDefault(s, 0);
            // 搜索下一个单词。需要判断最小距离，迪杰斯特拉算法的思路
            for (String nextString : nextStrings) {
                int next = map1.getOrDefault(nextString, Integer.MAX_VALUE);
                if (distance + 1 < next) {
                    map1.put(nextString, distance + 1);
                    queue.offer(nextString);
                }
            }
        }

        return map1.getOrDefault(endWord, 0);
    }

    private boolean isValid(String string1, String string2) {
        int count = 0;
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                if (count == 1) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }
}
