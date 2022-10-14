package other;

import java.util.Arrays;

/**
 * 假设一个整型数组，将奇数移动到数组左侧，偶数移动到数组右侧。
 * 例如：{1,2,3,4,5,6,7} 得 {1,3,5,7,2,4,6}
 * 要求
 * 1. 空间复杂度必须是O(1)
 * 2. 调整之后，数字的相对顺序不变。
 */
public class SortArrayByParityDemo {

    public static void main(String[] args) {
        SortArrayByParityDemo demo = new SortArrayByParityDemo();
        int[] array = new int[]{1, 2, 4, 5, 6, 7};
        demo.sortArrayByParity(array);
        System.out.println(Arrays.toString(array));
    }

    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0 && i > 0) {
                int value = nums[i];
                for (int j = i - 1; j >= left; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[left++] = value;
            } else if (nums[i] % 2 != 0) {
                left++;
            }
        }
        return nums;
    }
}
