package bfs;

import java.util.*;

/**
 * 安排课程
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

            List<Integer> list = map.get(prerequisites[i][0]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(prerequisites[i][0], list);
            }
            for (int j = 1; j < prerequisites[i].length; j++) {
                list.add(prerequisites[i][j]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int value = 0; value < numCourses; value++) {
            List<Integer> list = map.get(value);
            if (list == null) {
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
                if (list == null) {
                    continue;
                }
                list.remove(value);
                if (list.size() == 0) {
                    queue.offer(key);
                    map.put(key, null);
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
