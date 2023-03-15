package tree;

/**
 * 814. 二叉树剪枝
 * <p>
 * https://leetcode.cn/problems/binary-tree-pruning/
 */
public class PruneTreeDemo {

    public static void main(String[] args) {

    }

    private boolean isDelete;

    public TreeNode pruneTree(TreeNode root) {
        TreeNode node = root;
        while (true) {
            isDelete = false;
            node = deleteNode(node);
            if (!isDelete) {
                break;
            }
        }
        return node;
    }


    private TreeNode deleteNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null && root.val == 0) {
            isDelete = true;
            return null;
        }
        root.left = deleteNode(root.left);
        root.right = deleteNode(root.right);
        return root;
    }
}
