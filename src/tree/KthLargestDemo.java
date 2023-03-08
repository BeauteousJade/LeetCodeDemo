package tree;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * <p>
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class KthLargestDemo {

    public static void main(String[] args) {

    }

    private int count = 0;
    private int res = 0;

    /**
     * 先遍历right，然后遍历root,最后遍历left。
     * 根据二叉搜索树的特征，遍历顺序是一个从大到小的列表，所以直接找到第k个数字即可。
     */
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.right, k);
        helper(root, k);
        dfs(root.left, k);
    }

    private void helper(TreeNode root, int k) {
        if (count >= k) {
            return;
        }
        count++;
        if (count == k) {
            res = root.val;
        }
    }
}
