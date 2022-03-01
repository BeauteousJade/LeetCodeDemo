package binarySearch;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinDemo {

    public static void main(String[] args) {
        FindMinDemo demo = new FindMinDemo();
        int[] array = new int[]{11, 13, 15, 17};
        System.out.println(demo.findMin(array));
    }

    public int findMin(int[] nums) {
        int firstValue = nums[0];
        int lastValue = nums[nums.length - 1];
        if (firstValue <= lastValue) {
            return firstValue;
        }

        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public int findMinV2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

}
