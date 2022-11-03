package tree;

import java.util.*;

/**
 * 314. 二叉树的垂直遍历
 * <p>
 * https://leetcode.cn/problems/binary-tree-vertical-order-traversal/
 */
public class VerticalOrderDemo {


    public static void main(String[] args) {

    }


    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        queue.offer(root);
        queue1.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int pos = queue1.poll();
            List<Integer> list = map.computeIfAbsent(pos, k -> new ArrayList<>());
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                queue1.offer(pos - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                queue1.offer(pos + 1);
            }
        }
        Set<Integer> set = map.keySet();
        for (int pos : set) {
            res.add(map.get(pos));
        }
        return res;
    }
}
