package trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 820. 单词的压缩编码
 * <p>
 * https://leetcode.cn/problems/short-encoding-of-words/
 */
public class MinimumLengthEncodingDemo {

    public static void main(String[] args) {

    }

    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        Map<Trie, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie node = trie.insert(word);
            map.put(node, i);
        }

        int ans = 0;
        for (Map.Entry<Trie, Integer> entry : map.entrySet()) {
            if (entry.getKey().count == 0) {
                ans += words[entry.getValue()].length() + 1;
            }
        }
        return ans;

    }

    /**
     * 字段数存储后缀
     */
    private static class Trie {

        private final Trie[] children = new Trie[26];
        private int count;

        public Trie() {
        }

        public Trie insert(String word) {
            Trie node = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                    // 记录已当前字符串为后缀有多少个单词。
                    // 如果一个单词后缀node为0，表示它不属于别的单词后缀，即不能省略。
                    // 如果一个单词后缀node不为0，表示属于别的单词后缀，即能省略。
                    node.count++;
                }
                node = node.children[c - 'a'];
            }
            return node;
        }
    }
}
