package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 286. 墙与门
 * <p>
 * https://leetcode.cn/problems/walls-and-gates/?favorite=qg88wci
 */
public class WallsAndGatesDemo {

    public static void main(String[] args) {

        WallsAndGatesDemo demo = new WallsAndGatesDemo();

        int[][] array = new int[][]{{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};

        demo.wallsAndGates(array);

        for (int[] temp : array) {
            System.out.println(Arrays.toString(temp));
        }


    }

    public void wallsAndGates(int[][] rooms) {

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] array = queue.poll();
            int index = array[0] - 1;
            if (index >= 0 && rooms[index][array[1]] > rooms[array[0]][array[1]] + 1) {
                rooms[index][array[1]] = rooms[array[0]][array[1]] + 1;
                queue.offer(new int[]{index, array[1]});
            }
            index = array[0] + 1;
            if (index < rooms.length && rooms[index][array[1]] > rooms[array[0]][array[1]] + 1) {
                rooms[index][array[1]] = rooms[array[0]][array[1]] + 1;
                queue.offer(new int[]{index, array[1]});
            }
            index = array[1] - 1;
            if (index >= 0 && rooms[array[0]][index] > rooms[array[0]][array[1]] + 1) {
                rooms[array[0]][index] = rooms[array[0]][array[1]] + 1;
                queue.offer(new int[]{array[0], index});
            }

            index = array[1] + 1;
            if (index < rooms[0].length && rooms[array[0]][index] > rooms[array[0]][array[1]] + 1) {
                rooms[array[0]][index] = rooms[array[0]][array[1]] + 1;
                queue.offer(new int[]{array[0], index});
            }
        }
    }
}
