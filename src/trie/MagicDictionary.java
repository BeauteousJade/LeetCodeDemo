package trie;

import java.util.Arrays;

/**
 * 676. 实现一个魔法字典
 * <p>
 * https://leetcode.cn/problems/implement-magic-dictionary/
 */
class MagicDictionary {

    private Trie trie;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        trie = new Trie();
    }

    public void buildDict(String[] dictionary) {
        Arrays.stream(dictionary).forEach(trie::insert);
    }

    public boolean search(String searchWord) {
        return trie.search(searchWord);
    }


    private static class Trie {


        private final TreeNode root;

        public Trie() {
            root = new TreeNode();
        }


        public void insert(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TreeNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, root, false);
        }

        private boolean dfs(String word, int index, TreeNode root, boolean isModified) {
            if (index == word.length()) {
                return isModified && root.isEnd;
            }
            int wordIndex = word.charAt(index) - 'a';
            // 1. 如果说当前的child不等于空，就尝试搜索child.
            if (root.children[wordIndex] != null) {
                if (dfs(word, index + 1, root.children[wordIndex], isModified)) {
                    return true;
                }
            }
            // 2. 如果搜索失败，或者child为空，且没有修改过。表示当前修改，进行再次搜索。
            if (!isModified) {
                for (int i = 0; i < 26; i++) {
                    // 记住两点：
                    // 1. 跳过当前wordIndex.
                    // 2. 只有dfs为true，才return.
                    if (root.children[i] != null && i != wordIndex && dfs(word, index + 1, root.children[i], true)) {
                        return true;
                    }
                }
            }
            return false;
        }


        private static class TreeNode {

            private TreeNode[] children;
            private boolean isEnd;

            public TreeNode() {
                children = new TreeNode[26];
            }
        }

    }
}
