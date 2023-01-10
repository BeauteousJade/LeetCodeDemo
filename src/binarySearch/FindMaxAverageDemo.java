package binarySearch;

/**
 * 644. 子数组最大平均数 II
 * <p>
 * https://leetcode.cn/problems/maximum-average-subarray-ii/?favorite=qg88wci
 */
public class FindMaxAverageDemo {

    public static void main(String[] args) {
        FindMaxAverageDemo demo = new FindMaxAverageDemo();
        int[] array = {1, 12, -5, -6, 50, 3};
        System.out.println(demo.findMaxAverage(array, 4));
    }

    /**
     * 前缀和--超时
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        double res = -Double.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            for (int j = 0; j <= i - k + 1; j++) {
                res = Math.max(res, (sum[i] - (j == 0 ? 0 : sum[j - 1])) * 1.0 / (i - j + 1));
            }
        }
        return res;
    }


    /**
     * 二分--不懂
     */
    public double findMaxAverageV2(int[] nums, int k) {
        double maxVal = Integer.MIN_VALUE;
        double minVal = Integer.MAX_VALUE;
        for (int n : nums) {
            maxVal = Math.max(maxVal, n);
            minVal = Math.min(minVal, n);
        }
        double prevMid = maxVal, error = Integer.MAX_VALUE;
        while (error > 0.00001) {
            double mid = (maxVal + minVal) * 0.5;
            if (check(nums, mid, k)) {
                minVal = mid;
            } else {
                maxVal = mid;
            }
            error = Math.abs(prevMid - mid);
            prevMid = mid;
        }
        return minVal;
    }

    public boolean check(int[] nums, double mid, int k) {
        double sum = 0, prev = 0, minSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }
        if (sum >= 0) {
            return true;
        }
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev += nums[i - k] - mid;
            minSum = Math.min(prev, minSum);
            if (sum >= minSum) {
                return true;
            }
        }
        return false;
    }
}
