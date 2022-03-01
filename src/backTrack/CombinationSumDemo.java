package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSumDemo {

    public static void main(String[] args) {

    }

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }


    private void backTrack(int[] nums, int target, int count, List<Integer> list, int startIndex) {
        if (count == target) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = startIndex; i < nums.length; i++) {
                int num = nums[i];
                if (count + num <= target) {
                    list.add(num);
                    backTrack(nums, target, count + num, list, i);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
