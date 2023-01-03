package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 545. 二叉树的边界
 * <p>
 * https://leetcode.cn/problems/boundary-of-binary-tree/
 */
public class BoundaryOfBinaryTreeDemo {

    public static void main(String[] args) {

    }

    private final List<Integer> list = new ArrayList<>();
    private int rightIndex = 0;

    /**
     * 都是先遍历root，可以说是先序遍历
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //根
        list.add(root.val);

        //左边界
        leftBoundary(root.left);

        //底边界
        bottomBoundary(root.left);
        bottomBoundary(root.right);

        //右边界
        rightIndex = list.size();
        rightBoundary(root.right);

        return list;
    }

    private void leftBoundary(TreeNode root) {
        if (root != null) {
            // root 肯定是左边界。
            if (root.left != null || root.right != null) {
                list.add(root.val);
            }
            // 如果left不为空，那么left也为左边界，同时right不可能为边界。
            if (root.left != null) {
                leftBoundary(root.left);
            } else {
                // 如果left 为空，那么只能right为左边界了。
                leftBoundary(root.right);
            }
        }
    }

    private void rightBoundary(TreeNode root) {
        if (root != null) {
            // root 肯定是右边界。
            if (root.left != null || root.right != null) {
                list.add(rightIndex, root.val);
            }
            // 如果right不为空，那么right也为右边界，同时left不可能为边界。
            if (root.right != null) {
                rightBoundary(root.right);
            } else {
                // 如果right 为空，那么只能left为右边界了。
                rightBoundary(root.left);
            }
        }
    }

    private void bottomBoundary(TreeNode root) {
        if (root != null) {
            // 找到叶子节点，表示底边界。
            if (root.left == null && root.right == null) {
                list.add(root.val);
            }

            bottomBoundary(root.left);
            bottomBoundary(root.right);
        }
    }
}
