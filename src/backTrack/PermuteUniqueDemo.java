package backTrack;

import java.util.ArrayList;
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
        for (int i = 0; i < index; i++) {
            // 如果值相同，但是没有被选择，就需要跳过。
            // 因为相同的数字，只能选择一次，所以就选择第一次出现的那个数字即可。
            if (nums[i] == nums[index] && !rec[i]) {
                return true;
            }
        }
        return false;
    }
}
