package tree;

/**
 * 543. 二叉树的直径
 * <p>
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTreeDemo {

    public static void main(String[] args) {

    }

    private int ans = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
