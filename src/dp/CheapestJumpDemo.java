package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 656. 金币路径
 * <p>
 * https://leetcode.cn/problems/coin-path/
 */
public class CheapestJumpDemo {


    public static void main(String[] args) {
        CheapestJumpDemo demo = new CheapestJumpDemo();
        int[] array = {1, 2, 4, -1, 2};
        System.out.println(demo.cheapestJump(array, 2));
    }

    /**
     * dp
     */
    public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> res = new ArrayList<>();
        // dp[i]:表示从i处跳到默认所需得最小金币。
        int[] dp = new int[A.length];
        int[] next = new int[A.length];
        Arrays.fill(dp, -1);
        for (int i = A.length - 2; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            // 假设i得下一跳是j,尝试计算j的花费。
            for (int j = i + 1; j <= i + B && j < A.length; j++) {
                if (A[j] >= 0) {
                    // 从j到默认 + I处本身的花费，表示从i跳到默认所需花费。
                    int cost = A[i] + dp[j];
                    if (cost < minCost) {
                        minCost = cost;
                        next[i] = j;
                    }
                }
            }
            dp[i] = minCost;
        }
        int i = 0;
        for (; i < A.length && next[i] > 0; i = next[i]) {
            res.add(i + 1);
        }
        // 上面的next只更新到A.length - 2,所以最后一位需要特殊处理。
        if (i == A.length - 1 && A[i] >= 0) {
            res.add(A.length);
        } else {
            return new ArrayList<>();
        }
        return res;

    }

    /**
     * 暴力 -- dfs (超时)。
     */
    public List<Integer> cheapestJumpV2(int[] A, int B) {
        int[] next = new int[A.length];
        Arrays.fill(next, -1);
        jumpV2(A, B, 0, next);
        List<Integer> res = new ArrayList<>();
        int i;
        for (i = 0; i < A.length && next[i] > 0; i = next[i]) {
            res.add(i + 1);
        }
        if (i == A.length - 1 && A[i] >= 0) {
            res.add(A.length);
        } else {
            return new ArrayList<>();
        }
        return res;
    }

    public long jumpV2(int[] A, int B, int i, int[] next) {
        if (i == A.length - 1 && A[i] >= 0) {
            return A[i];
        }
        long minCost = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + B && j < A.length; j++) {
            if (A[j] >= 0) {
                long cost = A[i] + jumpV2(A, B, j, next);
                if (cost < minCost) {
                    minCost = cost;
                    next[i] = j;
                }
            }
        }
        return minCost;
    }


    /**
     * 记忆化 dfs.
     */
    public List<Integer> cheapestJumpV3(int[] A, int B) {
        int[] next = new int[A.length];
        Arrays.fill(next, -1);
        long[] memo = new long[A.length];
        jumpV3(A, B, 0, next, memo);
        List<Integer> res = new ArrayList<>();
        int i;
        for (i = 0; i < A.length && next[i] > 0; i = next[i]) {
            res.add(i + 1);
        }
        if (i == A.length - 1 && A[i] >= 0) {
            res.add(A.length);
        } else {
            return new ArrayList<>();
        }
        return res;
    }

    public long jumpV3(int[] A, int B, int i, int[] next, long[] memo) {
        if (memo[i] > 0) {
            return memo[i];
        }
        if (i == A.length - 1 && A[i] >= 0) {
            return A[i];
        }
        long minCost = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + B && j < A.length; j++) {
            if (A[j] >= 0) {
                long cost = A[i] + jumpV3(A, B, j, next, memo);
                if (cost < minCost) {
                    minCost = cost;
                    next[i] = j;
                }
            }
        }
        memo[i] = minCost;
        return minCost;
    }
}
