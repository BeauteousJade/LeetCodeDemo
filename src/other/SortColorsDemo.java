package other;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * <p>
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColorsDemo {

    public static void main(String[] args) {
        SortColorsDemo demo = new SortColorsDemo();
        int[] array = new int[]{2, 0, 2, 1, 1, 0};
        demo.sortColors(array);
        System.out.println(Arrays.toString(array));
    }

    public void sortColors(int[] nums) {
        int[] array = new int[3];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < array[0]) {
                nums[i] = 0;
            } else if (i < array[0] + array[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
