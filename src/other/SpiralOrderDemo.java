package other;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * <p>
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class SpiralOrderDemo {

    public static void main(String[] args) {

    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int index = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i]; // left to right.
            }
            if (++top > bottom) { // 换下一行。
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right]; // top to bottom.
            }
            if (left > --right) { // 换到左边的列
                break;
            }
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i]; // right to left.
            }
            if (top > --bottom) { // 换到上一行
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left]; // bottom to top.
            }
            if (++left > right) { // 换到右边的列。
                break;
            }
        }
        return res;
    }
}
