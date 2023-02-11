package twoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSumDemo {

    public static void main(String[] args) {
        TwoSumDemo demo = new TwoSumDemo();
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 100;
        System.out.println(Arrays.toString(demo.twoSum(array, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyNums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (copyNums[start] + copyNums[end] == target) {
                break;
            } else if (copyNums[start] + copyNums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        if (start < end) {
            int newStart = -1;
            int newEnd = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == copyNums[start] && newStart == -1) {
                    newStart = i;
                } else if (nums[i] == copyNums[end] && newEnd == -1) {
                    newEnd = i;
                }
                if (newStart != -1 && newEnd != -1) {
                    break;
                }
            }
            return new int[]{newStart, newEnd};
        }
        return new int[2];
    }

    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
