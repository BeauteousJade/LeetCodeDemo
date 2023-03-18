package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. 最近的请求次数
 * <p>
 * https://leetcode.cn/problems/number-of-recent-calls/
 */
class RecentCounter {

    private Queue<Integer> queue = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}