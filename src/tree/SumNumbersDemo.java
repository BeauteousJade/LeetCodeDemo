package tree;

/**
 * 129. 求根节点到叶节点数字之和
 * <p>
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class SumNumbersDemo {

    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
