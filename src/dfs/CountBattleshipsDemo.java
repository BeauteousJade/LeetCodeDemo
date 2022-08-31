package dfs;

/**
 * 419. 甲板上的战舰
 * <p>
 * https://leetcode-cn.com/problems/battleships-in-a-board/
 */
public class CountBattleshipsDemo {

    public static void main(String[] args) {

        CountBattleshipsDemo demo = new CountBattleshipsDemo();
        char[][] array = new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(demo.countBattleships(array));
    }

    public int countBattleships(char[][] board) {
        int count = 0;
        boolean[][] rec = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!rec[i][j] && board[i][j] == 'X' && help(board, rec, i, j)) {
                    count++;
                }
                rec[i][j] = true;
            }
        }
        return count;
    }

    private boolean help(char[][] board, boolean[][] rec, int i, int j) {
        if (i >= board.length || j >= board[i].length) {
            return true;
        }
        if (board[i][j] == 'X') {
            rec[i][j] = true;
            if (i + 1 < board.length && board[i + 1][j] == 'X') {
                return help(board, rec, i + 1, j);
            }
            if (j + 1 < board[i].length && board[i][j + 1] == 'X') {
                return help(board, rec, i, j + 1);
            }
            return true;
        }
        return false;
    }
}
