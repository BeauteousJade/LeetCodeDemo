package disjointSet;

import java.util.HashMap;
import java.util.Map;

/**
 * 695. 岛屿的最大面积
 * <p>
 * https://leetcode.cn/problems/max-area-of-island/
 */
public class MaxAreaOfIslandDemo {

    public static void main(String[] args) {

    }

    /**
     * dfs
     */
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }


    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }

    private int[] parent;

    /**
     * 并查集
     */
    public int maxAreaOfIslandV2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int current = i * n + j;
                    if (j > 0 && grid[i][j - 1] == 1) {
                        int left = (i) * n + j - 1;
                        add(left, current);
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        int top = (i - 1) * n + j;
                        add(current, top);
                    }
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int root = find(i * n + j);
                    res = Math.max(res, map.merge(root, 1, Integer::sum));

                }
            }
        }
        return res;
    }


    private int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }


    private void add(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        parent[rootB] = rootA;
    }
}
