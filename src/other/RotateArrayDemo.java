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


    /**
     * 操作	                 结果
     * 原始数组	             1 2 3 4 5 6 7
     * 翻转所有元素	         7 6 5 4 3 2 1
     * 翻转 [0, k] 区间的元素	 5 6 7 4 3 2 1
     * 翻转 [k, n] 区间的元素	 5 6 7 1 2 3 4
     */
    public void rotateV2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
