package array;

/**
 * 531. 孤独像素 I
 * <p>
 * https://leetcode.cn/problems/lonely-pixel-i/
 */
public class FindLonelyPixelDemo {

    public static void main(String[] args) {
        FindLonelyPixelDemo demo = new FindLonelyPixelDemo();
//        char[][] array = {{'W', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'W'}};

        char[][] array = {{'W', 'W', 'W'},
                {'W', 'W', 'W'},
                {'W', 'W', 'B'}};
        System.out.println(demo.findLonelyPixel(array));
    }

    public int findLonelyPixel(char[][] picture) {

        int[] rows = new int[picture.length];
        int[] cols = new int[picture[0].length];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
