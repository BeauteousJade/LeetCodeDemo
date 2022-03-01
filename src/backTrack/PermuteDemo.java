package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * https://leetcode-cn.com/problems/permutations/
 */
public class PermuteDemo {

    public static void main(String[] args) {
        PermuteDemo demo = new PermuteDemo();
        int[] array = new int[]{1, 2, 3};
        System.out.println(demo.permute(array));
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] rec = new boolean[nums.length];
        backTrack(nums, rec, new ArrayList<>());
        return result;
    }


    private void backTrack(int[] nums, boolean[] rec, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!rec[i]) {
                    rec[i] = true;
                    list.add(nums[i]);
                    backTrack(nums, rec, list);
                    rec[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
