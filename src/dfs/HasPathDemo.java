package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 490. 迷宫
 * <p>
 * https://leetcode.cn/problems/the-maze/
 */
public class HasPathDemo {

    public static void main(String[] args) {
//        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
//        int[] start = {0, 4};
//        int[] destination = {4, 4};
//        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
//        int[] start = {0, 4};
//        int[] destination = {3, 2};
        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] destination = {1, 2};
        HasPathDemo demo = new HasPathDemo();
        System.out.println(demo.hasPath(maze, start, destination));

    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    /**
     * 由于球要跑到边界处，或者墙处才能转弯，所以不能一开始就朝4个方向跑。只能朝一个方向跑，直到墙处才能转弯，也就是重新dfs.
     */
    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        // 只记录起点，因为某些点可以重复经过。
        visited[start[0]][start[1]] = true;
        int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
        while (r < maze[0].length && maze[start[0]][r] == 0) { //一直向右跑，跑到墙处才能停下，尝试转弯
            r++;
        }
        if (dfs(maze, new int[]{start[0], r - 1}, destination, visited)) { // 此时已经跑到墙下了，此时以该点从新的起点重新跑。
            return true;
        }
        while (l >= 0 && maze[start[0]][l] == 0) { //一直向右跑
            l--;
        }
        if (dfs(maze, new int[]{start[0], l + 1}, destination, visited)) {
            return true;
        }
        while (u >= 0 && maze[u][start[1]] == 0) {///一直向上跑
            u--;
        }
        if (dfs(maze, new int[]{u + 1, start[1]}, destination, visited)) {
            return true;
        }
        while (d < maze.length && maze[d][start[1]] == 0) { ///一直向下跑
            d++;
        }
        if (dfs(maze, new int[]{d - 1, start[1]}, destination, visited)) {
            return true;
        }
        return false;
    }


    /**
     * bfs的写法。
     * 注意的是queue里面存储的起点。
     */
    public boolean hasPathV2(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        // 只记录起点，因为某些点可以重复经过。
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                // 朝一个方向走，直到走到头。
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    // 然后把新的起点，放到queue里面，便于下次搜索。
                    queue.add(new int[]{x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}
