package twoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * <p>
 * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class FindContinuousSequenceDemo {

    public static void main(String[] args) {

    }

    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 2;
        List<List<Integer>> list = new ArrayList<>();
        while (left < right && right < target) {
            // 等差数列的计算公式。
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                List<Integer> res = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    res.add(i);
                }
                list.add(res);
                left++;
                right++;
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = new int[list.get(i).size()];
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }
}
