package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class RightSideViewDemo {

    public static void main(String[] args) {

    }

    /**
     * 广搜
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == size - 1) {
                    list.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return list;
    }


    public List<Integer> rightSideViewV2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        post(root, list);
        return list;
    }

    private void post(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            post(root.right, list);
        } else if (root.left != null) {
            post(root.left, list);
        }
        list.add(root.val);
    }

}
