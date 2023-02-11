package queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 239. 滑动窗口最大值
 * <p>
 * https://leetcode.cn/problems/sliding-window-maximum/
 */
public class MaxSlidingWindowDemo {


    public static void main(String[] args) {
        MaxSlidingWindowDemo demo = new MaxSlidingWindowDemo();
        System.out.println(Arrays.toString(demo.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        // 按照值从大到小排序。
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        res[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }
}
