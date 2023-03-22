package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. 键值映射
 * <p>
 * https://leetcode.cn/problems/map-sum-pairs/
 */
class MapSum {


    private final TreeNode treeNode = new TreeNode();

    public MapSum() {

    }

    public void insert(String key, int val) {
        treeNode.insert(key, val);
    }


    public int sum(String prefix) {
        return treeNode.sum(prefix);
    }

    private static class TreeNode {

        private final TreeNode[] children = new TreeNode[26];
        private final Map<String, Integer> map = new HashMap<>();

        private int count;

        public TreeNode() {
        }

        public void insert(String word, int count) {
            // 如果说之前相同的word，需要将之前的word对应的只给减掉，然后加上去现在的值。
            int newCount = count - map.getOrDefault(word, 0);
            map.put(word, count);
            TreeNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TreeNode();
                }
                node = node.children[c - 'a'];
                node.count += newCount;
            }
        }


        private TreeNode find(String prefix) {
            TreeNode node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return null;
                }
                node = node.children[c - 'a'];
            }
            return node;
        }

        public int sum(String prefix) {
            TreeNode node = find(prefix);
            if (node == null) {
                return 0;
            }
            return node.count;
        }
    }

}