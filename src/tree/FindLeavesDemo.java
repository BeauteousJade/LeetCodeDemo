package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 366. 寻找二叉树的叶子节点
 * <p>
 * https://leetcode.cn/problems/find-leaves-of-binary-tree/
 */
public class FindLeavesDemo {

    public static void main(String[] args) {

    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            // 删除之后，重新遍历删除，直到删除完毕。
            root = dfs(root, list);
            res.add(list);
        }
        return res;
    }

    /**
     * 删除当前root的所有子节点，然后在重新返回root.
     */
    private TreeNode dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = dfs(root.left, list);
        root.right = dfs(root.right, list);
        return root;
    }


}
