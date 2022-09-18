package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * <p>
 * https://leetcode.cn/problems/longest-valid-parentheses/
 */
public class LongestValidParenthesesDemo {


    public static void main(String[] args) {

    }

    public int longestValidParentheses(String s) {

        int res = 0;
        int[] dp = new int[s.length() + 1];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    //字符：......()
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    // 字符：XXX(YYY))
                    // dp[i - 1] : (YYY)
                    // dp[i - dp[i - 1] - 2] : XXX， 多-1的目的是要剪掉左侧的(
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }


    private int longestValidParenthesesV2(String s) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
