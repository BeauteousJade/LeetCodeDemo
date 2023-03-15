package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入二叉搜索树
 * <p>
 * https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/
 */
public class FindTargetDemo {

    public static void main(String[] args) {

    }

    private final Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
