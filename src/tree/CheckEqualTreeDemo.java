package tree;

import java.util.Stack;

/**
 * 663. 均匀树划分
 * <p>
 * https://leetcode.cn/problems/equal-tree-partition/
 */
public class CheckEqualTreeDemo {

    public static void main(String[] args) {

    }

    private final Stack<Integer> stack = new Stack<>();

    public boolean checkEqualTree(TreeNode root) {
        int total = sum(root);
        // 这里弹出，避免左右子树加起来正好等于root.
        stack.pop();
        if (total % 2 == 0) {
            for (int sum : stack) {
                if (sum == total / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = sum(root.left) + sum(root.right) + root.val;
        stack.push(sum);
        return stack.peek();
    }
}
