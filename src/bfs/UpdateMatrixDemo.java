package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * <p>
 * https://leetcode.cn/problems/01-matrix/
 */
public class UpdateMatrixDemo {

    public static void main(String[] args) {

    }

    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] array = queue.poll();
            for (int[] dir : dirs) {
                int newI = array[0] + dir[0];
                int newJ = array[1] + dir[1];
                // 这里不用判断距离，因为最先访问的，距离肯定最小。所以只需要看是否被访问即可。
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]) {
                    res[newI][newJ] = res[array[0]][array[1]] + 1;
                    queue.offer(new int[]{newI, newJ});
                    visited[newI][newJ] = true;
                }
            }
        }
        return res;
    }
}
