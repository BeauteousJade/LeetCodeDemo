package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 301. 删除无效的括号.
 * <p>
 * https://leetcode.cn/problems/remove-invalid-parentheses/?favorite=2cktkvj
 */
public class RemoveInvalidParenthesesDemo {

    public static void main(String[] args) {
        RemoveInvalidParenthesesDemo demo = new RemoveInvalidParenthesesDemo();
        System.out.println(demo.removeInvalidParentheses("((())"));
    }


    private final List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftRemove++;
            } else if (s.charAt(i) == ')') {
                if (leftRemove == 0) {
                    rightRemove++;
                } else {
                    leftRemove--;
                }
            }
        }

        helper(new StringBuilder(s), 0, leftRemove, rightRemove);
        return res;
    }

    private void helper(StringBuilder stringBuilder, int start, int leftRemove, int rightRemove) {
        if (leftRemove == 0 && rightRemove == 0) {
            if (isValid(stringBuilder)) {
                res.add(stringBuilder.toString());
            }
        } else {
            for (int i = start; i < stringBuilder.length(); i++) {
                // 如果当前字符跟上一个字符是相同的，直接过滤掉，不删除。
                // 因为((()),删除前三个中的任意一个其实都是都一样的效果，所以这里直接删除第一个，即start位置上的。
                if (i != start && stringBuilder.charAt(i) == stringBuilder.charAt(i - 1)) {
                    continue;
                }
                // 如果剩余的字符无法满足去掉的数量要求，直接返回
                if (leftRemove + rightRemove > stringBuilder.length() - i) {
                    return;
                }
                // 尝试去掉一个左括号
                if (leftRemove > 0 && stringBuilder.charAt(i) == '(') {
                    stringBuilder.delete(i, i + 1);
                    helper(stringBuilder, i, leftRemove - 1, rightRemove);
                    stringBuilder.insert(i, '(');
                }
                // 尝试去掉一个右括号
                if (rightRemove > 0 && stringBuilder.charAt(i) == ')') {
                    stringBuilder.delete(i, i + 1);
                    helper(stringBuilder, i, leftRemove, rightRemove - 1);
                    stringBuilder.insert(i, ')');
                }
            }
        }
    }

    private boolean isValid(StringBuilder stringBuilder) {
        int leftCount = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '(') {
                leftCount++;
            } else if (stringBuilder.charAt(i) == ')') {
                leftCount--;
                if (leftCount < 0) {
                    return false;
                }
            }
        }
        return leftCount == 0;
    }
}
