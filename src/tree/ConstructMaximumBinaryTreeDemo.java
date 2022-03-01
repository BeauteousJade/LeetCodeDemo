package tree;

/**
 * 654. 最大二叉树
 * <p>
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class ConstructMaximumBinaryTreeDemo {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = left;
        int maxValue = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = buildTree(nums, left, index - 1);
        root.right = buildTree(nums, index + 1, right);
        return root;
    }

}
