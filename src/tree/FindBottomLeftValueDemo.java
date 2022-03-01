package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * <p>
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftValueDemo {

    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode firstNode = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            firstNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (firstNode == null) {
                    firstNode = treeNode;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
        return firstNode.val;
    }
}
