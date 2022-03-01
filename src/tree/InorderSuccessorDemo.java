package tree;

import java.util.LinkedList;

/**
 * 285. 二叉搜索树中的中序后继
 * <p>
 * https://leetcode-cn.com/problems/inorder-successor-in-bst/
 */
public class InorderSuccessorDemo {

    public static void main(String[] args) {

    }

    LinkedList<TreeNode> queue;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        queue = new LinkedList<>();
        foreach(root);
        while (queue.size() > 0) {
            TreeNode cur = queue.poll();
            if (cur.val == p.val && queue.size() > 0)
                return queue.poll();
        }

        return null;
    }

    private void foreach(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            foreach(root.left);

        queue.add(root);

        if (root.right != null)
            foreach(root.right);
    }
}
