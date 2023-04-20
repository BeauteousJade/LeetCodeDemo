package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * <p>
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/
 */
public class DiffWaysToComputeDemo {

    public static void main(String[] args) {

    }

    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression, 0, expression.length() - 1);
    }

    private List<Integer> dfs(String string, int start, int end) {
        List<Integer> res = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            char c = string.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            List<Integer> left = dfs(string, start, i - 1);
            List<Integer> right = dfs(string, i + 1, end);
            for (int leftValue : left) {
                for (int rightValue : right) {
                    int ans = 0;
                    if (c == '+') {
                        ans = leftValue + rightValue;
                    } else if (c == '-') {
                        ans = leftValue - rightValue;
                    } else {
                        ans = leftValue * rightValue;
                    }
                    res.add(ans);
                }
            }
        }
        if (res.isEmpty()) {
            int ans = 0;
            for (int i = start; i <= end; i++) {
                ans = ans * 10 + string.charAt(i) - '0';
            }
            res.add(ans);
        }
        return res;
    }
}
