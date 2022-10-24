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

    boolean dfs(long mask) {
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
        for (int i = 1; i < n; ++i) {
            if ((mask & (1L << i)) == 0 || (mask & (1L << i - 1)) == 0) {
                continue;
            }
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
