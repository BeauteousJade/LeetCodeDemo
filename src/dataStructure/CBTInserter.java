package dataStructure;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 043. 往完全二叉树添加节点
 * <p>
 * https://leetcode.cn/problems/NaqhDT/?favorite=e8X3pBZi
 */
class CBTInserter {

    Queue<TreeNode> candidate;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.candidate = new LinkedList<>();
        this.root = root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            // 倒数第二层不完整的节点 和最后一层叶子节点。
            if (node.left == null || node.right == null) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            // 此时左右两个子节点都有了，就弹出。
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }
}