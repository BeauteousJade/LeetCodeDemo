package array;

/**
 * 533. 孤独像素 II
 * <p>
 * https://leetcode.cn/problems/lonely-pixel-ii/?favorite=qg88wci
 */
public class FindBlackPixelDemoV2 {

    public static void main(String[] args) {
        FindBlackPixelDemoV2 demo = new FindBlackPixelDemoV2();
//        char[][] array = {{'W', 'B', 'W', 'B', 'B', 'W'}, {'W', 'B', 'W', 'B', 'B', 'W'}, {'W', 'B', 'W', 'B', 'B', 'W'}, {'W', 'W', 'B', 'W', 'B', 'W'}};
//        char[][] array = {{'W', 'B', 'W', 'B', 'B', 'W'}, {'B', 'W', 'B', 'W', 'W', 'B'}, {'W', 'B', 'W', 'B', 'B', 'W'}, {'B', 'W', 'B', 'W', 'W', 'B'}, {'W', 'W', 'W', 'B', 'B', 'W'}, {'B', 'W', 'B', 'W', 'W', 'B'}};

        char[][] array = {{'W', 'B', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'W'}, {'W', 'B', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'W'}, {'W', 'W', 'W', 'W', 'W', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B'}, {'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'B', 'W', 'W'}, {'W', 'B', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'W'}, {'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'B', 'W', 'W'}, {'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'B', 'W', 'W'}, {'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'B', 'W', 'W'}};
        System.out.println(demo.findBlackPixel(array, 5));
    }

    public int findBlackPixel(char[][] picture, int target) {
        int[] rows = new int[picture.length];
        int[] cols = new int[picture[0].length];
        String[] strings = new String[picture.length];

        for (int i = 0; i < picture.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
                stringBuilder.append(picture[i][j]);
            }
            strings[i] = stringBuilder.toString();
        }

        int res = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && rows[i] == target && cols[j] == target) {
                    boolean isFlag = true;
                    for (int k = 0; k < picture.length; k++) {
                        // 是每行的排序是一样的，而不是B的数量相同。
                        if (picture[k][j] == 'B' && !strings[k].equals(strings[i])) {
                            isFlag = false;
                        }
                    }
                    if (isFlag) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
