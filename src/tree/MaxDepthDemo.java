package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthDemo {

    public static void main(String[] args) {
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res++;
        }
        return res;
    }

    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthV2(root.left), maxDepthV2(root.right));
    }

}
