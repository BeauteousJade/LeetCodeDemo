package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermuteUniqueDemo {

    public static void main(String[] args) {

        PermuteUniqueDemo demo = new PermuteUniqueDemo();
        System.out.println(demo.permuteUnique(new int[]{1, 2, 3}));
    }

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] rec = new boolean[nums.length];
        backTrack(new ArrayList<>(), nums, rec);
        return result;
    }


    /**
     * 回溯法
     */
    private void backTrack(List<Integer> list, int[] nums, boolean[] res) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (skip(nums, i, res)) {
                    continue;
                }
                if (!res[i] && !skip(nums, i, res)) {
                    list.add(nums[i]);
                    res[i] = true;
                    backTrack(list, nums, res);
                    res[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean skip(int[] nums, int index, boolean[] rec) {
        return index > 0 && nums[index - 1] == nums[index] && !rec[index - 1];
    }
}
