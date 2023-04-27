package tree;

/**
 * 814. 二叉树剪枝
 * <p>
 * https://leetcode.cn/problems/binary-tree-pruning/
 */
public class PruneTreeDemo {

    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
