package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II -- dfs
 * <p>
 * https://leetcode.cn/problems/subsets-ii/
 */
public class SubsetsWithDupDemo {

    public static void main(String[] args) {
        SubsetsWithDupDemo demo = new SubsetsWithDupDemo();
        int[] array = {4, 4, 4, 1, 4};
        System.out.println(demo.subsetsWithDup(array));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        dfs(0, 0, nums, list);
        return list;
    }

    private void dfs(int flag, int index, int[] nums, List<List<Integer>> list) {
        if (index == nums.length) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                if (((flag >> i) & 1) == 1) {
                    res.add(nums[i]);
                }
            }
            list.add(res);
        } else {
            dfs(flag, index + 1, nums, list);
            // 如果前一个值跟当前值相同，并且没有被选中，那么就忽略本次。
            // 因为这个值再第一次出现的时候就被选中了，不必再次选择。
            if (index > 0 && nums[index - 1] == nums[index] && (flag & (1 << (index - 1))) == 0) {
                return;
            }
            dfs(flag | 1 << index, index + 1, nums, list);
        }
    }
}
