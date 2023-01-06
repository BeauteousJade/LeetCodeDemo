package array;

/**
 * 573. 松鼠模拟
 * <p>
 * https://leetcode.cn/problems/squirrel-simulation/
 */
public class MinDistanceDemo {

    public static void main(String[] args) {
        int height = 7;
        int width = 5;
        int[] tree = {2, 2};
        int[] squirrel = {4, 4};
        int[][] nuts = {{3, 0}, {2, 5}};
        MinDistanceDemo demo = new MinDistanceDemo();
        System.out.println(demo.minDistance(height, width, tree, squirrel, nuts));
    }

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int[] nut : nuts) {
            sum += getDistance(nut, tree) * 2;
        }
        for (int[] firstNut : nuts) {
            int distance = sum - getDistance(firstNut, tree) + getDistance(squirrel, firstNut);
            res = Math.min(res, distance);
        }
        return res;
    }


    private int getDistance(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }
}
