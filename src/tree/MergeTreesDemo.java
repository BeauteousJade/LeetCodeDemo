package tree;

/**
 * 617. 合并二叉树
 * <p>
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class MergeTreesDemo {

    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root1 == null ? root2.val : (root2 == null ? root1.val : (root1.val + root2.val)));
        newRoot.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        newRoot.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return newRoot;
    }
}
