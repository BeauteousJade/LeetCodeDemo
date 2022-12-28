package dfs;

import java.util.Arrays;

/**
 * 505. 迷宫 II
 * <p>
 * https://leetcode.cn/problems/the-maze-ii/
 */
public class HasPathDemoV2 {

    public static void main(String[] args) {
        HasPathDemoV2 demo = new HasPathDemoV2();
        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] destination = {4, 4};
        System.out.println(demo.shortestDistance(maze, start, destination));
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] array = new int[maze.length][maze[0].length];
        for (int[] temp : array) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }
        array[start[0]][start[1]] = 0;
        dfs(maze, start, array);
        return array[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : array[destination[0]][destination[1]];
    }

    /**
     * 由于球要跑到边界处，或者墙处才能转弯，所以不能一开始就朝4个方向跑。只能朝一个方向跑，直到墙处才能转弯，也就是重新dfs.
     */
    public void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] dir : dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{x - dir[0], y - dir[1]}, distance);
            }
        }
    }
}
