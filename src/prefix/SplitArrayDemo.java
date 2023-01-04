package prefix;

import java.util.HashSet;
import java.util.Set;

/**
 * 548. 将数组分割成和相等的子数组
 * <p>
 * https://leetcode.cn/problems/split-array-with-equal-sum/?favorite=qg88wci
 */
public class SplitArrayDemo {

    public static void main(String[] args) {

        SplitArrayDemo demo = new SplitArrayDemo();
        int[] array = {1, 2, 1, 2, 1, 2, 1};
        System.out.println(demo.splitArray(array));
        System.out.println(demo.splitArrayV2(array));
    }

    /**
     * 前缀和暴力解法。
     */
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        // i,j,k不算，所以要减去三个，最少4个。
        if (n < 7) {
            return false;
        }
        int sum[] = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        /**
         * 1 <= i <= n−6
         * i+2 <= j <= n−4
         * j+2 <= k <= n−2
         */
        for (int i = 1; i < n - 5; i++) {
            int sum1 = sum[i - 1];
            for (int j = i + 2; j < n - 3; j++) {
                int sum2 = sum[j - 1] - sum[i];
                for (int k = j + 2; k < n - 1; k++) {
                    int sum3 = sum[k - 1] - sum[j];
                    int sum4 = sum[n - 1] - sum[k];
                    if (sum1 == sum2 && sum2 == sum3 && sum3 == sum4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean splitArrayV2(int[] nums) {
        int n = nums.length;
        // i,j,k不算，所以要减去三个，最少4个。
        if (n < 7) {
            return false;
        }
        int sum[] = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        // 1. 先选择一个j,将数组分为j的左右两个数组
        for (int j = 3; j < n - 3; j++) {
            Set<Integer> set = new HashSet<>();
            // 2. 从j的左侧子数组中找到一个 i，使得sum[i - 1] == sum[j - 1] - sum[i]。
            // 并且保存对应和保存到set里面。
            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }

            // 2. 从j的右侧子数组中，找到一个k，使得sum[k - 1] - sum[j] == sum[n - 1] - sum[k]。
            // 同时如果这个和在set当中，表示当前就是有一个有效划分，可以返回为true。
            for (int k = j + 2; k < n - 1; k++) {
                int target = sum[k - 1] - sum[j];
                if (sum[n - 1] - sum[k] == target && set.contains(target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
