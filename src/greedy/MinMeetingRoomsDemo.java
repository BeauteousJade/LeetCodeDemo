package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 253. 会议室 II
 * <p>
 * https://leetcode-cn.com/problems/meeting-rooms-ii/
 * <p>
 * 小顶堆，计算同时进行的最小会议数。
 */
public class MinMeetingRoomsDemo {

    public static void main(String[] args) {

    }

    /**
     * 如果计算的是重复的最大个数，以start排序；如果计算的没有重叠的个数，以end排序。
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }

        return queue.size();
    }
}
