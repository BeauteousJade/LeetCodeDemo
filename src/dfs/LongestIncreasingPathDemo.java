package dfs;

/**
 * 329. 矩阵中的最长递增路径
 * <p>
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathDemo {

    public static void main(String[] args) {

    }

    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        int res = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j, -1));
            }
        }

        return res;
    }

    private int dfs(int[][] array, int i, int j, int value) {
        if (i < 0 || j < 0 || i >= array.length || j >= array[0].length || value >= array[i][j]) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int res = 0;
        res = Math.max(res, dfs(array, i + 1, j, array[i][j]));
        res = Math.max(res, dfs(array, i - 1, j, array[i][j]));
        res = Math.max(res, dfs(array, i, j + 1, array[i][j]));
        res = Math.max(res, dfs(array, i, j - 1, array[i][j]));
        memo[i][j] = 1 + res;
        return 1 + res;
    }
}
