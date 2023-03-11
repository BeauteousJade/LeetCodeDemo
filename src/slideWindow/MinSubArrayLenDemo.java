package slideWindow;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * <p>
 * https://leetcode.cn/problems/2VG8Kg/
 */
public class MinSubArrayLenDemo {

    public static void main(String[] args) {
        MinSubArrayLenDemo demo = new MinSubArrayLenDemo();
        System.out.println(demo.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * 滑动窗口写法。
     *
     */
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (left <= right && sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
