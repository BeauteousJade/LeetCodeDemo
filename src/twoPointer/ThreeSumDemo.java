package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
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
            if ((i >= 1 && nums[i] != nums[i - 1] || i == 0)) {
                List<List<Integer>> list = twoSum(nums, -nums[i], i + 1);
                for (List<Integer> tempList : list) {
                    tempList.add(0, nums[i]);
                }
                result.addAll(list);
            }
        }
        return result;
    }


    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        int left = start;
        int right = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            if (target == nums[left] + nums[right]) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                right--;
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (target > nums[left] + nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
