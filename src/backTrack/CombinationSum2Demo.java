package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * <p>
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSum2Demo {

    public static void main(String[] args) {
        CombinationSum2Demo demo = new CombinationSum2Demo();
        System.out.println(demo.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5, 2, 1, 2}, 8));
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] rec = new boolean[candidates.length];
        backTrack(candidates, rec, target, 0, 0);
        return result;
    }


    private void backTrack(int[] candidates, boolean[] rec, int target, int sum, int index) {
        if (sum == target) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < rec.length; i++) {
                if (rec[i]) {
                    list.add(candidates[i]);
                }
            }
            result.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (skip(i, candidates, rec)) {
                    continue;
                }
                if (sum + candidates[i] <= target && !rec[i]) {
                    rec[i] = true;
                    backTrack(candidates, rec, target, sum + candidates[i], i + 1);
                    rec[i] = false;
                }
            }
        }
    }

    private boolean skip(int currentIndex, int[] candidates, boolean[] rec) {
        return currentIndex > 0 && candidates[currentIndex] == candidates[currentIndex - 1] && !rec[currentIndex - 1];
    }
}
