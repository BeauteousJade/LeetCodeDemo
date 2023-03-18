package queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * <p>
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 */
class MedianFinder {

    Queue<Integer> minQueue, maxQueue;

    public MedianFinder() {
        minQueue = new PriorityQueue<>(); // 小顶堆，保存较大的一半.从小到大排列。
        maxQueue = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半。从大到小排列。
    }

    public void addNum(int num) {
        // 需要维持两个队列的平衡性。
        if (minQueue.size() != maxQueue.size()) {
            minQueue.add(num);
            maxQueue.add(minQueue.poll());
        } else {
            maxQueue.add(num);
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        return minQueue.size() != maxQueue.size() ? minQueue.peek() : (minQueue.peek() + maxQueue.peek()) / 2.0;
    }
}