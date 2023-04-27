package tree;

/**
 * 129. 求根节点到叶节点数字之和
 * <p>
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
// TODO 下次
public class SumNumbersDemo {

    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(0, root);
    }


    private int dfs(int value, TreeNode root) {
        int res = 10 * value + root.val;
        if (root.left == null && root.right == null) {
            return res;
        }
        int leftRes = 0;
        if (root.left != null) {
            leftRes = dfs(res, root.left);
        }
        int rightRes = 0;
        if (root.right != null) {
            rightRes = dfs(res, root.right);
        }
        return leftRes + rightRes;
    }
}
