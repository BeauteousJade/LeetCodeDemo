package tree;

/**
 * 897. 递增顺序搜索树
 * <p>
 * https://leetcode.cn/problems/increasing-order-search-tree/
 */
public class IncreasingBSTDemo {

    public static void main(String[] args) {

    }

    private TreeNode newRoot;
    private TreeNode preNode;

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return newRoot;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        TreeNode right = root.right;
        if (newRoot == null) {
            newRoot = root;
        } else {
            preNode.right = root;
        }
        preNode = root;
        preNode.left = null;
        dfs(right);
    }
}
