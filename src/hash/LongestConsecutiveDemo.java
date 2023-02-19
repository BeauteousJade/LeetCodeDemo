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
        System.out.println(demo.longestConsecutiveV2(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
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


    private final Map<Integer, Integer> roots = new HashMap<>();

    /**
     * 并查集写法。
     */
    public int longestConsecutiveV2(int[] nums) {
        for (int i : nums) {
            roots.put(i, i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (roots.containsKey(nums[i] - 1)) {
                add(nums[i] - 1, nums[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = nums[i] - find(nums[i]) + 1;
            if (count < res) {
                count = res;
            }
        }
        return count;
    }

    private int find(int i) {
        int j = roots.getOrDefault(i, Integer.MIN_VALUE);
        if (i != j && j != Integer.MIN_VALUE) {
            roots.put(i, find(j));
        }
        return roots.getOrDefault(i, Integer.MIN_VALUE);
    }

    private void add(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        if (root1 == root2 && root1 != Integer.MIN_VALUE) {
            return;
        }
        roots.put(root2, root1);
    }
}
