package tree;

/**
 * 156. 上下翻转二叉树
 * <p>
 * https://leetcode.cn/problems/binary-tree-upside-down/?favorite=qg88wci
 */
public class UpsideDownBinaryTreeDemo {

    public static void main(String[] args) {

    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // root 为空，或者是叶子节点直接返回。
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        // 只递归left节点，因为right节点都是子节点。
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        // 对应位置交换
        TreeNode left = root.left;
        TreeNode right = root.right;
        left.left = right;
        left.right = root;

        // root的子节点置为空，避免循环引用。
        root.left = null;
        root.right = null;

        return newRoot;
    }
}
