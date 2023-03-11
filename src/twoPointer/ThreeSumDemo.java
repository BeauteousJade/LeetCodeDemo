package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSumDemo {

    public static void main(String[] args) {
        ThreeSumDemo demo = new ThreeSumDemo();
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(demo.threeSum(array));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> list = twoSum(i + 1, nums.length - 1, -nums[i], nums);
                for (List<Integer> res : list) {
                    res.add(0, nums[i]);
                }
                if (!list.isEmpty()) {
                    result.addAll(list);
                }

            }
        }
        return result;
    }


    private List<List<Integer>> twoSum(int start, int end, int target, int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                List<Integer> res = new LinkedList<>();
                res.add(nums[start]);
                res.add(nums[end]);
                list.add(res);
                start++;
                end--;
                // 排序重复元素。
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return list;
    }


}
