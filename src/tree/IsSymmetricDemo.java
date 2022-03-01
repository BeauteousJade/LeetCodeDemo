package tree;

/**
 * 101. 对称二叉树
 * <p>
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class IsSymmetricDemo {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }
        if (left == null) {
            return true;
        }
        if (left.val == right.val) {
            return isSymmetric(left.left, right.left) && isSymmetric(left.right, right.right);
        }
        return false;
    }
}
