package dfs;

/**
 * 439. 三元表达式解析器
 * <p>
 * https://leetcode.cn/problems/ternary-expression-parser/
 */
public class ParseTernaryDemo {

    public static void main(String[] args) {

    }

    public String parseTernary(String expression) {
        int n = expression.length();
        int checkLevel = 0;
        for (int j = 1; j < n; j++) {
            if (expression.charAt(j) == '?') {
                checkLevel++;
            }
            if (expression.charAt(j) == ':') {
                checkLevel--;
            }
            if (checkLevel == 0) {
                return (expression.charAt(0) == 'T') ? parseTernary(expression.substring(2, j)) : parseTernary(expression.substring(j + 1, n));
            }
        }
        return expression;
    }
}
