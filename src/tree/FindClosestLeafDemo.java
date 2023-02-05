package tree;

import java.util.*;

/**
 * 742. 二叉树最近的叶节点 -- dfs & bfs
 * <p>
 * https://leetcode.cn/problems/closest-leaf-in-a-binary-tree/?favorite=qg88wci
 */
public class FindClosestLeafDemo {

    public static void main(String[] args) {

    }

    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        // 1. 先把它转为图。
        dfs(graph, null, root);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        for (TreeNode node : graph.keySet()) {
            if (node != null && node.val == k) {
                queue.offer(node);
                seen.add(node);
            }
        }
        // 2. bfs 搜到第一个叶子节点。
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                List<TreeNode> nodeList = graph.get(node);
                // 叶子节点的边只有一个，那就是跟parent连接的边。
                if (nodeList.size() <= 1) {
                    return node.val;
                }
                for (TreeNode nextNode : nodeList) {
                    if (!seen.contains(nextNode)) {
                        queue.offer(nextNode);
                        seen.add(nextNode);
                    }
                }
            }
        }
        return 0;
    }


    private void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode parent, TreeNode node) {
        if (node != null) {
            graph.computeIfAbsent(node, treeNode -> new ArrayList<>()).add(parent);
            graph.computeIfAbsent(parent, treeNode -> new ArrayList<>()).add(node);
            dfs(graph, node, node.left);
            dfs(graph, node, node.right);
        }
    }
}
