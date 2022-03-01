package tree;

/**
 * 333. 最大 BST 子树
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/largest-bst-subtree/
 */
public class LargestBSTSubtreeDemo {

    private int value = 0;

    public static void main(String[] args) {

    }

    public int largestBSTSubtree(TreeNode root) {
        if (isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return getCount(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private int getCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getCount(root.left) + getCount(root.right);
    }

    private boolean isValidBST(TreeNode root, int lower, int upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}
