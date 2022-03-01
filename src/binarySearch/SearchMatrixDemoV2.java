package binarySearch;

/**
 * 240. 搜索二维矩阵 II
 * <p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class SearchMatrixDemoV2 {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            int value = matrix[x][y];
            if (value == target) {
                return true;
            } else if (value < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
