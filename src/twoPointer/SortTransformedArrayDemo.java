package twoPointer;

import java.util.Arrays;

/**
 * 360. 有序转化数组
 * <p>
 * https://leetcode.cn/problems/sort-transformed-array/
 */
public class SortTransformedArrayDemo {

    public static void main(String[] args) {
        SortTransformedArrayDemo demo = new SortTransformedArrayDemo();
        int[] nums = {-4, -2, 2, 4};
        System.out.println(Arrays.toString(demo.sortTransformedArray(nums, 1, 3, 5)));
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

        int[] res = new int[nums.length];
        // 一元一次函数。如果是b是正数，那么就递增，反之则递减。
        if (a == 0) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = help(nums[i], 0, b, c);
            }
            if (b < 0) {
                reverse(res);
            }
        }

        // 一元二次函数的对称轴（X坐标），如果a 为正数，该点是最小值，左侧递减，右侧递增；反之则是最大值。
        double mid = (-b * 1.0) / (a * 2);

        int right = 0;
        while (right < nums.length && nums[right] < mid) {
            right++;
        }
        int left = right - 1;
        int index = 0;
        while (left >= 0 && right < nums.length) {
            // 如果a为正数，那么res就是递增的。
            // 如果a为负数，那么res就是递减的。
            if (mid - nums[left] < nums[right] - mid) {
                res[index++] = help(nums[left--], a, b, c);
            } else {
                res[index++] = help(nums[right++], a, b, c);
            }
        }
        while (left >= 0) {
            res[index++] = help(nums[left--], a, b, c);
        }

        while (right < nums.length) {
            res[index++] = help(nums[right++], a, b, c);
        }
        // 递减，需要反转。
        if (a < 0) {
            reverse(res);
        }

        return res;
    }

    private int help(int value, int a, int b, int c) {
        return a * value * value + b * value + c;
    }


    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
