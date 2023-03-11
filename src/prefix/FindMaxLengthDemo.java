package prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * <p>
 * https://leetcode.cn/problems/A1NYOS/
 *
 * @see FindLongestSubarrayDemo 与此题一样的解法
 */
public class FindMaxLengthDemo {

    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count0 = 0;
        int count1 = 0;
        int length = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else {
                count1++;
            }
            int diff = count0 - count1;
            if (map.containsKey(diff)) {
                int index = map.get(diff);
                if (i - index > length) {
                    length = i - index;
                }
            }
            if (!map.containsKey(diff)) {
                map.put(diff, i);
            }
        }
        return length;
    }
}
