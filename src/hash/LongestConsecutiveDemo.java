package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 * <p>
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * <p>
 * 并查集
 */
public class LongestConsecutiveDemo {

    public static void main(String[] args) {
        LongestConsecutiveDemo demo = new LongestConsecutiveDemo();
        System.out.println(demo.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i] - 1)) {
                int currentNum = nums[i];
                int currentLength = 1;
                while (map.containsKey(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                res = Math.max(res, currentLength);
            }
        }
        return res;
    }
}
