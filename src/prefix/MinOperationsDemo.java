package prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 1658. 将 x 减到 0 的最小操作数
 * <p>
 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 */
public class MinOperationsDemo {

    public static void main(String[] args) {

    }

    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int sum = 0;
        map1.put(0, nums.length);
        // 后缀和，只记录第一次，因为题目要求最小。
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (!map1.containsKey(sum)) {
                map1.put(sum, i);
            }
        }
        sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = -1; i < nums.length; i++) {
            sum += i == -1 ? 0 : nums[i];
            // 如果x - sum 在后缀和中已有，那么操作次数 = 前缀和 的数目 + 后缀和的数目。
            if (map1.containsKey(x - sum) && i < map1.get(x - sum)) {
                res = Math.min(res, i + 1 + nums.length - map1.get(x - sum));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
