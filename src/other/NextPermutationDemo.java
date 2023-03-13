package other;

/**
 * 31. 下一个排列
 * <p>
 * https://leetcode.cn/problems/next-permutation/
 */
// TODO 硬记
public class NextPermutationDemo {

    public static void main(String[] args) {

    }

    /**
     * 1
     * 1 1
     * 1 1 1 1
     * 1 1 1 1 1
     * -   -
     * <p>
     * 1. 选择
     * 2. 交换
     * 3. 倒序
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找一个靠右的小值
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 然后找到右侧的大值，大于小值即可。
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 这里不用判断i >= 0。如果i < 0，表示当前数组是从大到小排列的，它下一个排列就是从小到大。
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
