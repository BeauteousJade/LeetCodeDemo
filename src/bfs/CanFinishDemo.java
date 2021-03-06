package bfs;

import java.util.*;

/**
 * 207. 课程表
 * <p>
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class CanFinishDemo {

    public static void main(String[] args) {
        CanFinishDemo demo = new CanFinishDemo();
        System.out.println(demo.canFinish(2, new int[][]{{1, 0}}));
    }

    // TODO 重点
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] nums : prerequisites) {
            List<Integer> list = map.computeIfAbsent(nums[0], k -> new ArrayList<>());
            list.add(nums[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                queue.offer(i);
                count++;
            }
        }
        Set<Integer> keySet = map.keySet();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer key : keySet) {
                List<Integer> list = map.get(key);
                boolean isRemove = list.remove(poll);
                if (isRemove && list.size() == 0) {
                    count++;
                    queue.offer(key);
                }
            }
        }
        return count == numCourses;
    }
}
