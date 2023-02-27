package memory;

import java.util.HashMap;
import java.util.Map;

/**
 * 294. 翻转游戏 II
 * <p>
 * https://leetcode.cn/problems/flip-game-ii/
 */
public class CanWinDemo {

    public static void main(String[] args) {

        int a = 1;
        int b = 1;
    }

    int n;
    Map<Long, Boolean> memo = new HashMap<>();

    public boolean canWin(String s) {
        n = s.length();
        long mask = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '+') {
                mask |= 1L << i;
            }
        }
        return dfs(mask);
    }

    /**
     * 返回为true，表示当前选手会赢。
     * 第一次是己方，第二次是对方。
     */
    boolean dfs(long mask) {
        // 记忆化搜索。已经有结果的存起来，避免重复计算。
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
        for (int i = 1; i < n; ++i) {
            // 如果连续的两个不是反转为0,则放弃本次。
            if ((mask & (1L << i)) == 0 || (mask & (1L << i - 1)) == 0) {
                continue;
            }
            // 此时返回为true，表示是对方会赢。
            // 因为己方已经操作，操作：将第i位和第i - 1位反转位0.
            if (dfs(mask ^ (1L << i ^ (1L << i - 1)))) {
                continue;// 对方必胜则不选这条路
            }
            // 对方只要有一个必败，我方选这条路则必胜
            memo.put(mask, true);
            return true;
        }
        // 我方无论选哪条路对方都必胜 或者 我方无路可选
        memo.put(mask, false);
        return false;
    }
}
