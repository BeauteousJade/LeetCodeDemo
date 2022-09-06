package tree;

/**
 * 226. 翻转二叉树
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertTreeDemo {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        invertTree(left);
        invertTree(right);
        root.left = right;
        root.right = left;
        return root;
    }

}
