package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 752. 打开转盘锁
 * <p>
 * https://leetcode.cn/problems/open-the-lock/
 */
public class OpenLockDemo {

    public static void main(String[] args) {

    }

    public int openLock(String[] deadends, String target) {
        Map<String, Integer> map = new HashMap<>();
        // 死锁数字，先将他们放入进去，下面bfs的时候不能走到。
        for (String string : deadends) {
            if (string.equals("0000")) {
                return -1;
            }
            map.put(string, -1);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        map.put("0000", 0);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            int distance = map.getOrDefault(s, 0);
            if (s.equals(target)) {
                return distance;
            }
            char[] array = s.toCharArray();
            // 四个数字都可以+和-，一共八种情况。
            for (int i = 0; i < 4; i++) {
                char temp = array[i];
                array[i] = temp == '0' ? '9' : (char) (temp - 1);
                String next = new String(array);
                int nextDistance = map.getOrDefault(next, Integer.MAX_VALUE);
                if (distance + 1 < nextDistance) {
                    map.put(next, distance + 1);
                    queue.offer(next);
                }
                array[i] = temp == '9' ? '0' : (char) (temp + 1);
                next = new String(array);
                nextDistance = map.getOrDefault(next, Integer.MAX_VALUE);
                if (distance + 1 < nextDistance) {
                    map.put(next, distance + 1);
                    queue.offer(next);
                }
                array[i] = temp;
            }
        }

        return -1;
    }
}
