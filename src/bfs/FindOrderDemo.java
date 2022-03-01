package bfs;

import java.util.*;

/**
 * 210. 课程表 II
 * <p>
 * https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class FindOrderDemo {

    public static void main(String[] args) {
        FindOrderDemo demo = new FindOrderDemo();
        int numCourses = 4;
        int[][] array = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(demo.findOrder(numCourses, array)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = map.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>());
            for (int j = 1; j < prerequisites[i].length; j++) {
                list.add(prerequisites[i][j]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int value = 0; value < numCourses; value++) {
            if(!map.containsKey(value)){
                queue.offer(value);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            Set<Integer> keySet = map.keySet();
            for (Integer key : keySet) {
                List<Integer> list = map.get(key);
                if (list.size() == 0) {
                    continue;
                }
                boolean isRemove = list.remove(value);
                if (isRemove && list.size() == 0) {
                    queue.offer(key);
                }
            }
            result[index++] = value;
        }

        if (index != numCourses) {
            return new int[]{};
        }
        return result;
    }
}
