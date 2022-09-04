package dp;


import tree.TreeNode;

/**
 * 337. 打家劫舍 III
 * <p>
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class RobDemoV3 {

    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        int[] res = robInternal(root);
        return Math.max(res[0], res[1]);
    }

    // TODO 重点
    private int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        // 0:偷root
        // 1:不偷Root.
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
