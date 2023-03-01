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
        // 这里弹出的总和，综合不参与计算。避免左右子树加起来正好等于root.
        stack.pop();
        if (total % 2 == 0) {
            for (int sum : stack) {
                // 这里判断的是总和的一半。如果有一个子树和等于总和一般，那么另一边的子树也是总和的一半，这个子树带Root。
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
