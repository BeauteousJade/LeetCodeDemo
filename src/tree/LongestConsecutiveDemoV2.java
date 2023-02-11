package tree;

/**
 * 549. 二叉树中最长的连续序列
 * <p>
 * https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence-ii/
 */
public class LongestConsecutiveDemoV2 {

    public static void main(String[] args) {

    }

    private int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }

    private int[] helper(TreeNode root) {
        //arr[0]为递增序列路径数，arr[1]为递减序列路径数
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 1;
        if (root == null) {
            // 算上了父节点，所以这里默认都是1，而不是0.
            return arr;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        //判断root在左子树中处于递增还是递减
        if (root.left != null) {
            if (root.left.val - 1 == root.val) {
                arr[1] = left[1] + 1;
            } else if (root.left.val + 1 == root.val) {
                arr[0] = left[0] + 1;
            }
        }

        //判断root在右子树中处于递增还是递减，最后arr结果中保留最大值
        if (root.right != null) {
            if (root.right.val - 1 == root.val) {
                arr[1] = Math.max(arr[1], right[1] + 1);
            } else if (root.right.val + 1 == root.val) {
                arr[0] = Math.max(arr[0], right[0] + 1);
            }
        }

        //统计结果
        // 因为上面left 和right + 1，所以多计算了一次，需要-1.
        res = Math.max(res, arr[0] + arr[1] - 1);
        return arr;
    }
}
