package dataStructure;

import java.util.TreeMap;

/**
 * 剑指 Offer II 058. 日程表
 * <p>
 * https://leetcode.cn/problems/fi9suh/
 */
class MyCalendar {
    private final TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // 返回小于等于key的最大键，如果不存在这样的键，则返回null。
        Integer prev = calendar.floorKey(start);
        // 返回大于等于key的最小键，如果不存在这样的键，则返回null。
        Integer next = calendar.ceilingKey(start);
        // 如果不存在上一个，或者上一个的结束时间小于当前的开始时间；且不存在下一个或者，当前的结束时间必须大于下一个的开始时间。
        // 才能预定成功。
        // 总而言之，在[start，end)这个区间里面不能有其他的会议。
        if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
