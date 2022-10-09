package backTrack;

import java.util.ArrayList;
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
                if (sum + candidates[i] <= target && !rec[i] && !skip(candidates, rec, candidates[i], i)) {
                    rec[i] = true;
                    backTrack(candidates, rec, target, sum + candidates[i], i + 1);
                    rec[i] = false;
                }
            }
        }
    }

    private boolean skip(int[] candidates, boolean[] rec, int value, int index) {
        for (int i = 0; i < index; i++) {
            // 如果值相同，但是没有被选择，就需要跳过。
            // 因为相同的数字，只能选择一次，所以就选择第一次出现的那个数字即可。
            if (candidates[i] == value && !rec[i]) {
                return true;
            }
        }
        return false;
    }
}
