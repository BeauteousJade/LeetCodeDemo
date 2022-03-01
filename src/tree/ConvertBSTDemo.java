package tree;

/**
 * 538. 把二叉搜索树转换为累加树
 * <p>
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class ConvertBSTDemo {

    public static void main(String[] args) {

    }

    private int sum = 0;

    /**
     * 反中序遍历
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            // sum 记录的是，当前root的right节点之和
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
