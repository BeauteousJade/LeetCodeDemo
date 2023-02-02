package simulation;

import java.util.Arrays;

/**
 * 723. 粉碎糖果 -- 模拟。
 * <p>
 * https://leetcode.cn/problems/candy-crush/
 */
public class CandyCrushDemo {

    public static void main(String[] args) {
        CandyCrushDemo demo = new CandyCrushDemo();
        int[][] array = {{110, 5, 112, 113, 114}, {210, 211, 5, 213, 214}, {310, 311, 3, 313, 314}, {410, 411, 412, 5, 414}, {5, 1, 512, 3, 3}, {610, 4, 1, 613, 614}, {710, 1, 2, 713, 714}, {810, 1, 2, 1, 1}, {1, 1, 2, 2, 2}, {4, 1, 4, 4, 1014}};
        demo.candyCrush(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }


    /**
     * 4步：
     * 1. 标记可以清除的糖果。
     * 2. 清除对应的糖果。
     * 3. 掉落糖果。
     * 4. 如果上述有清除糖果，再次遍历是否需要请求 -- 递归。
     */
    public int[][] candyCrush(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean isToDo = false;
        // 1. 标记。
        for (int i = 0; i < row; i++) {
            for (int j = 0; j + 2 < col; j++) {
                int v = Math.abs(board[i][j]);
                // 这里之所以需要比较绝对值，是因为可能连续超过3个，前3个已经更新为负数，第4个也需要更新为负数。所以这里判断绝对值。
                if (v != 0 && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                    isToDo = true;
                }
            }
        }

        for (int i = 0; i + 2 < row; i++) {
            for (int j = 0; j < col; j++) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                    isToDo = true;
                }
            }
        }

        for (int i = 0; i < col; i++) {
            int currentRow = row - 1;
            for (int j = row - 1; j >= 0; j--) {
                // 2. 清除
                if (board[j][i] > 0) {
                    board[currentRow--][i] = board[j][i];
                }
            }
            // 3. 掉落。
            while (currentRow >= 0) {
                board[currentRow--][i] = 0;
            }
        }
        // 4. 尝试再次清除。
        return isToDo ? candyCrush(board) : board;
    }
}
