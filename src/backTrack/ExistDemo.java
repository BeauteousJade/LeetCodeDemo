package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 79. 单词搜索
 * <p>
 * https://leetcode-cn.com/problems/word-search/
 */
// TODO 下次
public class ExistDemo {

    public static void main(String[] args) {

        ExistDemo demo = new ExistDemo();
        char[][] array = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(demo.exist(array, "ABCCEDS"));

    }

    private boolean result = false;

    public boolean exist(char[][] board, String word) {
        boolean[][] rec = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = false;
                    backTrack(board, rec, new ArrayList<>(), word, i, j);
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void backTrack(char[][] board, boolean[][] rec, List<Character> list, String word, int i, int j) {
        if (list.size() == word.length()) {
            result = true;
        } else {
            if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || rec[i][j] || result) {
                return;
            }
            if (board[i][j] == word.charAt(list.size())) {
                list.add(word.charAt(list.size()));
                rec[i][j] = true;
                backTrack(board, rec, list, word, i - 1, j);
                backTrack(board, rec, list, word, i + 1, j);
                backTrack(board, rec, list, word, i, j - 1);
                backTrack(board, rec, list, word, i, j + 1);
                rec[i][j] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
