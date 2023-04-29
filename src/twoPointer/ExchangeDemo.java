package twoPointer;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class ExchangeDemo {

    public static void main(String[] args) {
        ExchangeDemo demo = new ExchangeDemo();
        System.out.println(Arrays.toString(demo.exchangeV2(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }

    /**
     * 这个不保证相对顺序.时间复杂度是O(n)
     */
    public int[] exchange(int[] array) {
        int fastIndex = 0;
        int slowIndex = 0;
        while (fastIndex < array.length) {
            if (array[fastIndex] % 2 == 1) {
                int temp = array[slowIndex];
                array[slowIndex] = array[fastIndex];
                array[fastIndex] = temp;
                slowIndex++;
            }
            fastIndex++;
        }
        return array;
    }

    /**
     * 这个能保证相对顺序。时间复杂度是O(n * n)
     */
    public int[] exchangeV2(int[] array) {
        int fastIndex = 0;
        int slowIndex = 0;
        while (fastIndex < array.length) {
            if (array[fastIndex] % 2 == 1) {
                int temp = array[fastIndex];
                int moveIndex = fastIndex;
                // 移动前面所有偶数
                while (moveIndex > slowIndex) {
                    array[moveIndex] = array[moveIndex - 1];
                    moveIndex--;
                }
                array[slowIndex] = temp;
                slowIndex++;
            }
            fastIndex++;
        }
        return array;
    }
}
