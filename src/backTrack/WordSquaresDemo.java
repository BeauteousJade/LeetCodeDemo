package backTrack;

import java.util.*;

/**
 * 425. 单词方块
 * <p>
 * https://leetcode.cn/problems/word-squares/
 */
public class WordSquaresDemo {


    public static void main(String[] args) {
        WordSquaresDemo demo = new WordSquaresDemo();
        String[] array = {"area", "lead", "wall", "lady", "ball"};
        System.out.println(demo.wordSquares(array));
    }

    public List<List<String>> wordSquares(String[] words) {

        List<List<String>> results = new ArrayList<>();
        HashMap<String, List<String>> prefixHashTable = buildPrefixHashTable(words);

        for (String word : words) {
            LinkedList<String> wordSquares = new LinkedList<>();
            wordSquares.add(word);
            this.backtracking(1, word.length(), wordSquares, results, prefixHashTable);
        }
        return results;
    }

    protected void backtracking(int step, int length, LinkedList<String> wordSquares, List<List<String>> results, HashMap<String, List<String>> prefixHashTable) {
        if (step == length) {
            results.add(new LinkedList<>(wordSquares));
            return;
        }

        StringBuilder prefix = new StringBuilder();
        // 第一次进来需要从第二个字符开始，因为第二个word要以第一个第一个word的第二个字符打头。
        for (String word : wordSquares) {
            prefix.append(word.charAt(step));
        }
        List<String> list = prefixHashTable.get(prefix.toString());
        if (list == null) {
            list = Collections.emptyList();
        }
        for (String candidate : list) {
            wordSquares.add(candidate);
            this.backtracking(step + 1, length, wordSquares, results, prefixHashTable);
            wordSquares.removeLast();
        }
    }

    protected HashMap<String, List<String>> buildPrefixHashTable(String[] words) {
        HashMap<String, List<String>> prefixHashTable = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i < word.length(); ++i) {
                String prefix = word.substring(0, i);
                List<String> wordList = prefixHashTable.get(prefix);
                if (wordList == null) {
                    wordList = new ArrayList<>();
                    wordList.add(word);
                    prefixHashTable.put(prefix, wordList);
                } else {
                    wordList.add(word);
                }
            }
        }
        return prefixHashTable;
    }
}
