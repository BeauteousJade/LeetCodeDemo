package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题59 - II. 队列的最大值
 * <p>
 * https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/
 */
public class MaxQueue {
    Queue<Integer> queue;
    // 双向队列。
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        // 单调递增的队列。
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        // 如果pop 的数据跟跟最大值的数据相同，那么需要同时pop.
        if (queue.peek().equals(deque.peekFirst())) {
            deque.pollFirst();
        }
        return queue.poll();
    }
}
