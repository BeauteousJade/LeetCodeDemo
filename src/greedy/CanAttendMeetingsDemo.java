package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 252. 会议室
 * <p>
 * https://leetcode.cn/problems/meeting-rooms/?favorite=qg88wci
 */
public class CanAttendMeetingsDemo {

    public static void main(String[] args) {
        CanAttendMeetingsDemo demo = new CanAttendMeetingsDemo();

        int[][] array = {{13,15},{1,13},{6,9}};

        System.out.println(demo.canAttendMeetings(array));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1) {
            return true;
        }
        // 按照结束时间从小到大进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        // 队列里面从小到大排序
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // 不能while,只能if
            if (!queue.isEmpty() && intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size() <= 1;
    }
}
