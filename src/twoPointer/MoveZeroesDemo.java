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
        int indexNow = 0;
        int indexNum = 0;
        while (indexNow < nums.length) {
            if(nums[indexNow] != 0){
                nums[indexNum++] = nums[indexNow];
            }
            indexNow++;
        }
        for (int i = indexNum; i < nums.length;i++){
            nums[i] = 0;
        }
    }
}
