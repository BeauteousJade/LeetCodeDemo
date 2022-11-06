package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 317. 离建筑物最近的距离
 * <p>
 * https://leetcode.cn/problems/shortest-distance-from-all-buildings/
 */
public class ShortestDistanceDemo {

    public static void main(String[] args) {
        ShortestDistanceDemo demo = new ShortestDistanceDemo();
        int[][] array = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(demo.shortestDistanceV2(array));
    }

    private final int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    /**
     * 思路：
     * (1) 从每一个建筑物开始进行广度优先搜索
     * (2) 在搜索的同时计算每一个空格到这个建筑物的距离
     * (3) 在搜索的同时将每一个空格到每一个建筑物的距离进行累加，得到每个空格到所有建筑物的距离
     * (4) 取空格到所有建筑物的最小距离
     * <p>
     * 以房子出发。
     */
    public int shortestDistance(int[][] grid) {
        int res = Integer.MAX_VALUE;
        // 记录是对应位置的空格跟所有房子的距离。
        int[][] distances = new int[grid.length][grid[0].length];
        // 用来表示空地
        int mark = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 每次遍历到一个房子，表示需要更新，用来表示下一个房子的空地。
                    res = search(grid, i, j, mark--, distances);
                }
            }
        }
        return res;
    }


    private int search(int[][] grid, int i, int j, int mark, int[][] distances) {
        Queue<int[]> queue = new LinkedList<>();
        // 队列中每个数组有 3 个元素，分别表示：
        // 第1个元素表示当前坐标到建筑物的距离
        // 第2个元素和第3个元素表示坐标值
        // 第1个元素的初始值为 0 的原因是：一开始的时候从当前建筑物到当前建筑物的距离是 0
        queue.offer(new int[]{0, i, j});
        int m = grid.length;
        int n = grid[0].length;
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] array = queue.poll();
            for (int[] dir : dirs) {
                int newRow = array[1] + dir[0];
                int newCol = array[2] + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == mark) {
                    // (2) 在搜索的同时计算每一个空格到这个建筑物的距离
                    int newDistance = array[0] + 1;
                    // (3) 在搜索的同时将每一个空格到每一个建筑物的距离进行累加
                    distances[newRow][newCol] += newDistance;
                    // (4) 取空格到所有建筑物的最小距离
                    res = Math.min(res, distances[newRow][newCol]);
                    queue.offer(new int[]{newDistance, newRow, newCol});
                    // 和 mark 标识对应
                    grid[newRow][newCol]--;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    /**
     * 以空地出发。
     * <p>
     * 超时
     */
    public int shortestDistanceV2(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int totalCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    totalCount++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int newRes = searchV2(grid, i, j, totalCount);
                    res = Math.min(res, newRes);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    private int searchV2(int[][] grid, int i, int j, int totalCount) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] rec = new boolean[grid.length][grid[0].length];
        queue.offer(new int[]{0, i, j});
        int res = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] array = queue.poll();
            int row = array[1];
            int col = array[2];
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 2) {
                continue;
            }
            if (rec[row][col]) {
                continue;
            }
            rec[row][col] = true;
            if (grid[row][col] == 1) {
                res += array[0];
                count++;
                continue;
            }
            for (int[] dir : dirs) {
                queue.offer(new int[]{array[0] + 1, row + dir[0], col + dir[1]});
            }
        }
        // 必须能达到所有的房子，这个空地才是有效的。
        return count == totalCount ? res : Integer.MAX_VALUE;
    }
}
