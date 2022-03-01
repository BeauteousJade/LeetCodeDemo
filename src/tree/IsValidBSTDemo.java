package tree;


/**
 * 98. 验证二叉搜索树
 * <p>
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBSTDemo {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
