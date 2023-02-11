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
        int ret = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.right != null) {
                queue.offer(p.right);
            }
            if (p.left != null) {
                queue.offer(p.left);
            }
            ret = p.val;
        }
        return ret;
    }
}
