package prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 1590. 使数组和能被 P 整除
 * <p>
 * https://leetcode.cn/problems/make-sum-divisible-by-p/
 */
public class MinSubarrayDemo {

    public static void main(String[] args) {
        MinSubarrayDemo demo = new MinSubarrayDemo();
        System.out.println(demo.minSubarray(new int[]{3, 1, 4, 2}, 6));

    }

    public int minSubarray(int[] nums, int p) {
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % p;
            // sum - x 可能会为负数，这里避免diff为负数，所以加一个p。
            // 假设：x % p = y % p。
            // 如果x可能会为负数，那么 (x + p) % p = y % p。
            int diff = (sum - x + p) % p;
            if (map.containsKey(diff)) {
                res = Math.min(res, i - map.get(diff));
            }
            map.put(sum, i); // f[i] mod p = y，因此哈希表记录 y 对应的下标为 i
        }
        return res == nums.length ? -1 : res;
    }
}
