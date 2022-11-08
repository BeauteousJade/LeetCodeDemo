package dfs;

import java.util.Arrays;

/**
 * 351. 安卓系统手势解锁
 * <p>
 * https://leetcode.cn/problems/android-unlock-patterns/
 */
public class NumberOfPatternsDemo {

    public static void main(String[] args) {
        NumberOfPatternsDemo demo = new NumberOfPatternsDemo();
        System.out.println(demo.numberOfPatterns(1, 2));
    }

    boolean[] used = new boolean[9];

    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += dfs(i, -1);
            Arrays.fill(used, false);
        }
        return res;
    }

    private int dfs(int step, int last) {
        // 0 步只有一种，那就是都不选。
        if (step == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < 9; i++) {
            if (!used[i] && isValid(last, i)) {
                used[i] = true;
                res += dfs(step - 1, i);
                used[i] = false;
            }
        }
        return res;
    }

    private boolean isValid(int last, int cur) {
        if (last == -1) {
            return true;
        }
        if (last > cur) {
            return isValid(cur, last);
        }
        if (last == 0 && cur == 2) {
            return used[1];
        }
        if (last == 0 && cur == 6) {
            return used[3];
        }
        if (last == 0 && cur == 8) {
            return used[4];
        }
        if (last == 1 && cur == 7) {
            return used[4];
        }

        if (last == 2 && cur == 6) {
            return used[4];
        }
        if (last == 2 && cur == 8) {
            return used[5];
        }
        if (last == 3 && cur == 5) {
            return used[4];
        }
        if (last == 6 && cur == 8) {
            return used[7];
        }
        return true;
    }

}
