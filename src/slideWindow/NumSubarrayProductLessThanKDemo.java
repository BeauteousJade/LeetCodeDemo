package slideWindow;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * <p>
 * https://leetcode.cn/problems/ZVAVXX/?favorite=e8X3pBZi
 */
public class NumSubarrayProductLessThanKDemo {

    public static void main(String[] args) {
        NumSubarrayProductLessThanKDemo demo = new NumSubarrayProductLessThanKDemo();

        System.out.println(demo.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 1;
        while (right < nums.length) {
            sum *= nums[right];
            while (sum >= k) { // 不满足要求
                sum /= nums[left++];
            }
            // 直接计算子数组的数量。
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
