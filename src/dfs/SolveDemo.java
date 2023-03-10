package dfs;

import java.util.Arrays;

/**
 * 130. 被围绕的区域
 * <p>
 * https://leetcode.cn/problems/surrounded-regions/
 */
public class SolveDemo {

    public static void main(String[] args) {
        char[][] array = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}};
        SolveDemo demo = new SolveDemo();
        demo.solve(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }


    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            dfs(i, 0, board);
            dfs(i, m - 1, board);
        }
        for (int i = 0; i < m; i++) {
            dfs(0, i, board);
            dfs(n - 1, i, board);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }


    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }


}
