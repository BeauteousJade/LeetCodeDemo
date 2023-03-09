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
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (array[index] != null) {
                node.left = new TreeNode(array[index]);
                queue.offer(node.left);
            }
            index++;
            if (array[index] != null) {
                node.right = new TreeNode(array[index]);
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }

}
