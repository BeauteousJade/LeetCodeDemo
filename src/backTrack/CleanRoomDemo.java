package backTrack;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 489. 扫地机器人
 * <p>
 * https://leetcode.cn/problems/robot-room-cleaner/
 */
public class CleanRoomDemo {


    public static void main(String[] args) {
        int[][] array = {
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        CleanRoomDemo demo = new CleanRoomDemo();
        demo.cleanRoom(new RobotImpl(1, 3, array));
    }

    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet();
    Robot robot;

    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void backtrack(int row, int col, int d) {
        visited.add(new Pair(row, col));
        robot.clean();
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; ++i) {
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                backtrack(newRow, newCol, newD);
                // 这里只是回退到移动的状态。
                goBack();
            }
            // 换个方向。
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    public class Pair<F, S> {
        public F first;
        public S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            Pair<F, S> p = (Pair<F, S>) o;
            return Objects.equals(p.first, first) && Objects.equals(p.second, second);
        }

        @Override
        public int hashCode() {
            return first.hashCode() ^ second.hashCode();
        }
    }

    public static class RobotImpl implements Robot {

        private int i;
        private int j;
        private final int[][] array;

        private int d = 0; // 0:向上，1向左，2向下，3向右。

        public RobotImpl(int i, int j, int[][] array) {
            this.i = i;
            this.j = j;
            this.array = array;
        }

        @Override
        public boolean move() {

            int newI = d == 0 ? i - 1 : (d == 2 ? i + 1 : i);
            int newJ = d == 1 ? j - 1 : (d == 3 ? j + 1 : j);
            if (newI >= 0 && newI < array.length && newJ >= 0 && newJ < array[0].length && array[newI][newJ] == 1) {
//                System.out.println("newI = " + newI + " newJ = " + newJ);
                i = newI;
                j = newJ;
                return true;
            }
            return false;
        }

        @Override
        public void turnLeft() {
            if (d == 0) {
                d = 1;
            } else if (d == 1) {
                d = 2;
            } else if (d == 2) {
                d = 3;
            } else if (d == 3) {
                d = 0;
            }
        }

        @Override
        public void turnRight() {
            if (d == 0) {
                d = 3;
            } else if (d == 3) {
                d = 2;
            } else if (d == 2) {
                d = 1;
            } else if (d == 1) {
                d = 0;
            }
        }

        @Override
        public void clean() {

        }
    }

    interface Robot {
        // 若下一个方格为空，则返回true，并移动至该方格
        // 若下一个方格为障碍物，则返回false，并停留在原地
        boolean move();

        // 在调用turnLeft/turnRight后机器人会停留在原位置
        // 每次转弯90度
        void turnLeft();

        void turnRight();

        // 清理所在方格
        void clean();

    }
}
