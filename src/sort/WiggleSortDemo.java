package sort;


import java.util.Arrays;

/**
 * 280. 摆动排序
 * <p>
 * https://leetcode.cn/problems/wiggle-sort/
 */
public class WiggleSortDemo {

    public static void main(String[] args) {
        WiggleSortDemo demo = new WiggleSortDemo();
        int[] array = {3, 5, 2, 1, 6, 4};
        demo.wiggleSortV2(array);
        System.out.println(Arrays.toString(array));
    }


    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }


    private void wiggleSortV2(int[] nums) {
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            less = !less;
        }
    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
