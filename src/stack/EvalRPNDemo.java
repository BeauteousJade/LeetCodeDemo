package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * <p>
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
public class EvalRPNDemo {

    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        Set<String> hashSet = new HashSet<>();
        hashSet.add("+");
        hashSet.add("-");
        hashSet.add("*");
        hashSet.add("/");

        for (String string : tokens) {
            if (hashSet.contains(string)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num(num1, num2, string));
            } else {
                stack.push(Integer.parseInt(string));
            }
        }
        return stack.peek();
    }

    private int num(int num1, int num2, String label) {
        switch (label) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }
}
