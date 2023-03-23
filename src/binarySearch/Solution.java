package binarySearch;

import java.util.Arrays;

/**
 * 528. 按权重随机选择
 * <p>
 * https://leetcode.cn/problems/random-pick-with-weight/
 */
class Solution {
    int[] pre;
    int total;

    public Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            pre[i] = pre[i - 1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int x = (int) (Math.random() * total) + 1;
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int left = 0;
        int right = pre.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (pre[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}