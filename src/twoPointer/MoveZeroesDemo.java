package twoPointer;

import java.util.Arrays;

/**
 * 283. 移动零
 * <p>
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroesDemo {

    public static void main(String[] args) {
        MoveZeroesDemo demo = new MoveZeroesDemo();
        int[] array = new int[]{0, 1, 2};
        demo.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0 && left < right) {
                nums[left] = nums[right];
                nums[right] = 0;
            }
            if (nums[left] != 0) {
                left++;
            }
            right++;
        }
    }

    public void moveZeroesV2(int[] nums) {
        int fastIndex = 0;
        int slowIndex = 0;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex++] = nums[fastIndex];
            }
            fastIndex++;
        }
        for (int i = slowIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
