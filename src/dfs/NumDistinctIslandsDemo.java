package dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 694. 不同岛屿的数量 -- dfs
 * <p>
 * https://leetcode.cn/problems/number-of-distinct-islands/
 */
public class NumDistinctIslandsDemo {

    public static void main(String[] args) {
        int[][] array = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
        NumDistinctIslandsDemo demo = new NumDistinctIslandsDemo();
        System.out.println(demo.numDistinctIslands(array));
    }


    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    dfs(i, j, 100, grid, stringBuilder);
                    set.add(stringBuilder.toString());
                }
            }
        }
        return set.size();
    }


    private void dfs(int i, int j, int dir, int[][] grid, StringBuilder sb) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(dir);
        dfs(i + 1, j, 1, grid, sb);
        dfs(i - 1, j, 2, grid, sb);
        dfs(i, j + 1, 3, grid, sb);
        dfs(i, j - 1, 4, grid, sb);
        // 这里不能删除，只能记一个反方向的信息。如果使用删除的话，当遍历完成，sb是一个空串。
        sb.append(-dir);
    }
}
