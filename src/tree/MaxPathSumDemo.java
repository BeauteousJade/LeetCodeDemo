package tree;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 */
public class MaxPathSumDemo {


    public static void main(String[] args) {

    }


    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return ans;
    }


    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(traverse(root.left), 0);
        int right = Math.max(traverse(root.right), 0);
        int res = root.val + left + right;
        ans = Math.max(res, ans);
        // 这里不能通过加left和right。因为child 不能经过root节点。
        return root.val + Math.max(left, right);
    }
}
