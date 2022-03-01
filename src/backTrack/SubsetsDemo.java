package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * https://leetcode-cn.com/problems/subsets/
 */
public class SubsetsDemo {

    public static void main(String[] args) {
        SubsetsDemo demo = new SubsetsDemo();
        int[] array = new int[]{1, 2, 3};
        System.out.println(demo.subsets(array));
    }

    private final List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        backTrack(new ArrayList<>(), nums, 0);
        return result;
    }

    private void backTrack(List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            // 选择
            list.add(nums[index]);
            backTrack(list, nums, index + 1);
            list.remove(list.size() - 1);
            // 不选择
            backTrack(list, nums, index + 1);
        }
    }
}
