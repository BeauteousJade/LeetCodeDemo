package dfs;

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
}
