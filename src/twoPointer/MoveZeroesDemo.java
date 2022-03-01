package twoPointer;

import java.util.Arrays;

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
}
