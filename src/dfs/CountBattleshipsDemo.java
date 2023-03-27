package dfs;

/**
 * 419. 甲板上的战舰
 * <p>
 * https://leetcode-cn.com/problems/battleships-in-a-board/
 */
// TODO 下次
public class CountBattleshipsDemo {

    public static void main(String[] args) {

        CountBattleshipsDemo demo = new CountBattleshipsDemo();
        char[][] array = new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(demo.countBattleships(array));
    }

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    help(board, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void help(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != 'X') {
            return;
        }
        board[i][j] = '.';
        help(board, i + 1, j);
        help(board, i, j + 1);
    }
}
