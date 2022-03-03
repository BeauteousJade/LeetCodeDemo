package tree;

/**
 * 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class IsBalancedDemo {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDeep = getDeep(root.left);
        int rightDeep = getDeep(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftDeep - rightDeep) <= 1;
    }

    private int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDeep(root.left), getDeep(root.right));
    }

}
