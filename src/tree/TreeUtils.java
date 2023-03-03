package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的Util方法。
 */
public final class TreeUtils {

    /**
     * 树的层级遍历。
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                list.add(treeNode.val);
            }
            result.add(list);
        }
        return result;
    }


    public static TreeNode buildTree(Integer[] array) {
        TreeNode[] tree = new TreeNode[array.length];
        for (int i = 0; i < array.length; i++) {
            Integer value = array[i];
            if (value != null) {
                tree[i] = tree[i] == null ? new TreeNode(value) : tree[i];
                if (2 * (i + 1) - 1 < array.length && array[2 * (i + 1) - 1] != null) {
                    TreeNode left = new TreeNode(array[2 * (i + 1) - 1]);
                    tree[i].left = left;
                    tree[2 * (i + 1) - 1] = left;
                }
                if (2 * (i + 1) < array.length && array[2 * (i + 1)] != null) {
                    TreeNode right = new TreeNode(array[2 * (i + 1)]);
                    tree[i].right = right;
                    tree[2 * (i + 1)] = right;
                }
            }
        }
        return tree[0];
    }

}
