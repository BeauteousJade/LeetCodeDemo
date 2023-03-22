package trie;

import java.util.List;

/**
 * 648. 单词替换
 * <p>
 * https://leetcode.cn/problems/replace-words/
 */
public class ReplaceWordsDemo {

    public static void main(String[] args) {

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        dictionary.forEach(trie::insert);
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = trie.search(strings[i]);
        }
        return String.join(" ", strings);
    }


    class Trie {
        private TreeNode root = null;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TreeNode(' ');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (node.child[c] == null) {
                    node.child[c] = new TreeNode((char) ('a' + c));
                }
                node = node.child[c];
            }
            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public String search(String prefix) {
            return findNode(prefix);
        }


        private String findNode(String word) {
            StringBuilder stringBuilder = new StringBuilder();
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.isEnd) {
                    return stringBuilder.toString();
                }
                if (node.child[c - 'a'] == null) {
                    return word;
                }
                node = node.child[c - 'a'];
                stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }


        private class TreeNode {
            //节点的值
            public char value;
            //节点的孩子们
            public TreeNode child[];
            //是否是最终节点
            public boolean isEnd = false;

            public TreeNode(char value) {
                this.value = value;
                child = new TreeNode[26];
            }
        }
    }
}
