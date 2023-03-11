package prefix;

/**
 * 剑指 Offer II 013. 二维子矩阵的和
 * <p>
 * https://leetcode.cn/problems/O4NDxx/
 */
class NumMatrix {

    private int[] prefix;

    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                prefix[index] = index == 0 ? matrix[i][j] : prefix[i - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int sum = 0;

        for (int i = row1; i <= row2; i++) {
            sum += prefix[i * matrix[0].length + col2] + matrix[i][col1] - prefix[i * matrix[0].length + col1];
        }
        return sum;
    }
}