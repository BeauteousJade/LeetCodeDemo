package tree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树
 * <p>
 * https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            return stringBuilder.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        stringBuilder.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            stringBuilder.append(",").append(node.left == null ? "null" : node.left.val);
            stringBuilder.append(",").append(node.right == null ? "null" : node.right.val);
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] strings = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!strings[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strings[index]));
                queue.add(node.left);
            }
            index++;
            if (!strings[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(strings[index]));
                queue.add(node.right);
            }
            index++;
        }

        return root;
    }
}