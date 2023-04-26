package tree;

import java.util.*;

/**
 * 104. 二叉树的最大深度
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
// TODO 下次
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


    /**
     * dfs 非递归写法。
     *
     */
    public int maxDepthV3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(1);
        int res = 1;

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            int currentHeight = stack2.pop();
            if (node.left != null) {
                stack1.push(node.left);
                stack2.push(currentHeight + 1);
            }
            if (node.right != null) {
                stack1.push(node.right);
                stack2.push(currentHeight + 1);
            }
            res = Math.max(res, currentHeight);
        }
        return res;
    }

}
