package tree;

/**
 * 298. 二叉树最长连续序列
 * <p>
 * https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence/
 */
public class LongestConsecutiveDemo {

    public static void main(String[] args) {

    }


    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }

    private int dfs(TreeNode p, TreeNode parent, int length) {
        if (p == null) {
            return 0;
        }
        length = parent != null && p.val == parent.val + 1 ? length + 1 : 1;
        return Math.max(length, Math.max(dfs(p.left, p, length), dfs(p.right, p, length)));
    }
}
