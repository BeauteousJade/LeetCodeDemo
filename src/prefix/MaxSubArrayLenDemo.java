package prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. 和等于 k 的最长子数组长度
 * <p>
 * https://leetcode.cn/problems/maximum-size-subarray-sum-equals-k/?favorite=qg88wci
 */
public class MaxSubArrayLenDemo {

    public static void main(String[] args) {
        MaxSubArrayLenDemo demo = new MaxSubArrayLenDemo();
        int[] array = {1, -1, 5, -2, 3};
        System.out.println(demo.maxSubArrayLen(array, 3));
    }

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res = Math.max(i - map.get(sum - k), res);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }
}
