package dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 666. 路径总和 IV
 * <p>
 * https://leetcode.cn/problems/path-sum-iv/
 */
public class PathSumDemo {


    public static void main(String[] args) {
        PathSumDemo demo = new PathSumDemo();
        int[] array = {113, 215, 221};
        System.out.println(demo.pathSum(array));
    }

    private int ans = 0;
    private final Map<Integer, Integer> map = new HashMap<>();

    public int pathSum(int[] nums) {
        for (int num : nums) {
            map.put(num / 10, num % 10);
        }
        sum(nums[0] / 10, 0);
        return ans;
    }

    private void sum(int node, int sum) {
        if (!map.containsKey(node)) {
            return;
        }
        sum += map.get(node);
        int depth = node / 10;
        int pos = node % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            ans += sum;
        } else {
            sum(left, sum);
            sum(right, sum);
        }
    }
}
