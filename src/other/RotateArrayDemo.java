package other;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * <p>
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArrayDemo {

    public static void main(String[] args) {
        RotateArrayDemo demo = new RotateArrayDemo();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        demo.rotate(array, k);
        System.out.println(Arrays.toString(array));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        int tempArray[] = new int[k];

        for (int i = nums.length - k; i < nums.length; i++) {
            tempArray[i - (nums.length - k)] = nums[i];
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[k + i] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tempArray[i];
        }
    }
}
