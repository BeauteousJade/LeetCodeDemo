package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. 缺失的区间
 * <p>
 * https://leetcode.cn/problems/missing-ranges/
 */
public class FindMissingRangesDemo {

    public static void main(String[] args) {
        FindMissingRangesDemo demo = new FindMissingRangesDemo();
        System.out.println(demo.findMissingRanges(new int[]{0, 1, 3, 50, 75}, -1, 77));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper) {
                list.add(String.valueOf(lower));
            } else {
                list.add(lower + "->" + upper);
            }
            return list;
        }
        if (lower < nums[0] - 1) {
            list.add(lower + "->" + (nums[0] - 1));
        } else if (lower == nums[0] - 1) {
            list.add(String.valueOf(lower));
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 2) {
                list.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
            } else if (nums[i] - nums[i - 1] == 2) {
                list.add(String.valueOf(nums[i - 1] + 1));
            }
        }
        if (upper > nums[nums.length - 1] + 1) {
            list.add((nums[nums.length - 1] + 1) + "->" + upper);
        } else if (upper == nums[nums.length - 1] + 1) {
            list.add(String.valueOf(upper));
        }
        return list;
    }
}
