package binarySearch;

/**
 * 74. 搜索二维矩阵
 * <p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class SearchMatrixDemo {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = matrix[mid / n][mid % n];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrixV2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n;
        while (left < right) {
            int mid = (left + right) / 2;
            int value = matrix[mid / n][mid % n];
            if (value >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left < m * n && matrix[left / n][left % n] == target;
    }
}
