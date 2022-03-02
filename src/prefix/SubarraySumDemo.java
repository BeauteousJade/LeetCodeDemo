package prefix;

import java.util.HashMap;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * <p>
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumDemo {

    public static void main(String[] args) {
        SubarraySumDemo demo = new SubarraySumDemo();
        int[] array = new int[]{1, 2, 3};
        int k = 3;
        System.out.println(demo.subarraySum(array, k));
    }

    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            for (int j = 0; j < i; j++) {
                if (prefixSum[i] - prefixSum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySumV2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
