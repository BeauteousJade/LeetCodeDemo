package topk;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer II 059. 数据流的第 K 大数值
 * <p>
 * https://leetcode.cn/problems/jBjn9C/
 */
class KthLargest {

    private final Queue<Integer> queue;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}