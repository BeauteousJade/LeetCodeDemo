package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 * <p>
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class SetZeroesDemo {

    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    set1.add(i);
                    set2.add(j);
                }
            }
        }

        for (int line : set1) {
            Arrays.fill(matrix[line], 0);
        }
        for (int line : set2) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][line] = 0;
            }
        }
    }
}
