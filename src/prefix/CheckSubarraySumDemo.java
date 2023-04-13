package prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 * <p>
 * <p>
 * 前缀和。
 * <p>
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
// TODO 下次
public class CheckSubarraySumDemo {

    public static void main(String[] args) {
        CheckSubarraySumDemo demo = new CheckSubarraySumDemo();
        int[] array = new int[]{23, 2, 4, 6, 6};
        int k = 8;
        System.out.println(demo.checkSubarraySum(array, k));
    }


    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        // 存储余数。
        Map<Integer, Integer> map = new HashMap<>();
        // 如果前缀数组存储index，的话，默认第一位要存储-1.
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            //当 prefixSums[q]−prefixSums[p] 为 k 的倍数时，prefixSums[p] 和prefixSums[q] 除以 k 的余数相同。
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
