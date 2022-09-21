package tree;

/**
 * 437. 路径总和 III
 * <p>
 * https://leetcode-cn.com/problems/path-sum-iii/
 */
public class PathSumDemoV3 {

    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int count = pathSumInternal(root, targetSum);
        count += pathSum(root.right, targetSum);
        count += pathSum(root.left, targetSum);
        return count;
    }

    private int pathSumInternal(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == targetSum) {
            // 可能子树存在负数，所以不能return。
            count++;
        }
        count += pathSumInternal(root.left, targetSum - root.val);
        count += pathSumInternal(root.right, targetSum - root.val);
        return count;
    }
}
