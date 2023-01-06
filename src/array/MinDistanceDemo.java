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
        // 首先计算，所有松果到树的距离，* 2是因为取得松果，还要回到树。
        for (int[] nut : nuts) {
            sum += getDistance(nut, tree) * 2;
        }
        for (int[] firstNut : nuts) {
            // 然后，以每个松果为起点，计算最小距离。
            // 因为第一个松果不用去树，所以可以直接去，这里需要加上松鼠到第一个松果的距离，并且要减去树到第一个松果的距离(因为只是单行程)
            int distance = sum - getDistance(firstNut, tree) + getDistance(squirrel, firstNut);
            res = Math.min(res, distance);
        }
        return res;
    }


    private int getDistance(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }
}
