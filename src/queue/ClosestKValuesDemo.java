package queue;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 272. 最接近的二叉搜索树值 II
 * <p>
 * https://leetcode.cn/problems/closest-binary-search-tree-value-ii/
 */
public class ClosestKValuesDemo {

    public static void main(String[] args) {

    }


    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // 升序排列。
        Queue<Integer> queue1 = new PriorityQueue<>();
        // 降序排列。
        Queue<Integer> queue2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        dfs(root, target, queue1, queue2);
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            if (queue2.isEmpty() || !queue1.isEmpty() && Math.abs(queue1.peek() - target) <= Math.abs(queue2.peek() - target)) {
                res.add(queue1.poll());
            } else {
                res.add(queue2.poll());
            }
        }
        return res;
    }


    private void dfs(TreeNode root, double target, Queue<Integer> queue1, Queue<Integer> queue2) {
        if (root == null) {
            return;
        }
        if (root.val <= target) {
            queue2.offer(root.val);
        } else {
            queue1.offer(root.val);
        }
        dfs(root.left, target, queue1, queue2);
        dfs(root.right, target, queue1, queue2);
    }
}
