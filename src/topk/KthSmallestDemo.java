package topk;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 378. 有序矩阵中第 K 小的元素
 * <p>
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestDemo {

    public static void main(String[] args) {
    }

    public int kthSmallest(int[][] matrix, int k) {
        // 从大到小。
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.offer(matrix[i][j]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.poll();
    }
}
