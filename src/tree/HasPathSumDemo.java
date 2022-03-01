package tree;

/**
 * 112. 路径总和
 * <p>
 * https://leetcode-cn.com/problems/path-sum/
 */
public class HasPathSumDemo {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null && targetSum != 0) {
            return false;
        }
        if (root == null || targetSum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) | hasPathSum(root.right, targetSum - root.val);
    }
}
