package queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 252. 会议室
 * <p>
 * https://leetcode.cn/problems/meeting-rooms/?favorite=qg88wci
 */
// TODO 下次
public class CanAttendMeetingsDemo {

    public static void main(String[] args) {
        CanAttendMeetingsDemo demo = new CanAttendMeetingsDemo();

        int[][] array = {{13, 15}, {1, 13}, {6, 9}};

        System.out.println(demo.canAttendMeetings(array));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        // 开始时间时间从小到大。
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // 这里弹出一个，因为当前只会复用一个会议室。
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }

        return queue.size() <= 1;
    }
}
