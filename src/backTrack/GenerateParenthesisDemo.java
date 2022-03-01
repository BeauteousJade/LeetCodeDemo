package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesisDemo {

    public static void main(String[] args) {
        GenerateParenthesisDemo demo = new GenerateParenthesisDemo();
        System.out.println(demo.generateParenthesis(3));
    }

    private final List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(n, new StringBuilder(), 0, 0);
        return result;
    }


    private void backTrack(int n, StringBuilder stringBuilder, int leftCount, int rightCount) {
        if (leftCount == rightCount && leftCount == n) {
            result.add(stringBuilder.toString());
        }
        if (leftCount > n || rightCount > n) {
            return;
        }
        if (leftCount < n) {
            stringBuilder.append("(");
            backTrack(n, stringBuilder, leftCount + 1, rightCount);
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        }
        if (rightCount < leftCount) {
            stringBuilder.append(")");
            backTrack(n, stringBuilder, leftCount, rightCount + 1);
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        }
    }
}
