package tree;

/**
 * 270. 最接近的二叉搜索树值
 * <p>
 * https://leetcode-cn.com/problems/closest-binary-search-tree-value/
 */
// TODO 重点。
public class ClosestValueDemo {

    public static void main(String[] args) {

    }

    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
