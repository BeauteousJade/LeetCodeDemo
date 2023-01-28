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
        stack.push(sum(root.left) + sum(root.right) + root.val);
        return stack.peek();
    }
}
