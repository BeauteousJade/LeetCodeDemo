package other;

import java.util.Arrays;

public class RotateDemo {

    public static void main(String[] args) {

        RotateDemo demo = new RotateDemo();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        demo.rotate(matrix);
    }

    public void rotate(int[][] matrix) {


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
//        print(matrix);
//        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
//        print(matrix);
    }


    private void print(int[][] array) {
        for (int[] a : array) {
            System.out.println(Arrays.toString(a));
        }
    }
}
