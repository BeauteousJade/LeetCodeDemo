package prefix;

import java.util.Arrays;

/***
 * 370. 区间加法
 *
 * https://leetcode.cn/problems/range-addition/
 */
public class GetModifiedArrayDemo {

    public static void main(String[] args) {
        GetModifiedArrayDemo demo = new GetModifiedArrayDemo();


        int[][] array = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};

        System.out.println(Arrays.toString(demo.getModifiedArray(5, array)));
    }

    /**
     * 暴力解法。
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        for (int[] array : updates) {
            for (int i = array[0]; i <= array[1]; i++) {
                res[i] += array[2];
            }
        }
        return res;
    }

    /**
     * 前缀数组。差分数组的解法。
     * <p>
     * a[starIndex] 比前一个元素多了inc。
     * a[endIndex + 1] 比前一个元素少了inc.
     */
    private int[] getModifiedArrayV2(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] array : updates) {
            res[array[0]] += array[2];
            if (array[1] < length - 1) {
                res[array[1] + 1] -= array[2];
            }
        }
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
