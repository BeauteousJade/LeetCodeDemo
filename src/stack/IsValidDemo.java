package stack;

import java.util.Stack;

public class IsValidDemo {

    public static void main(String[] args) {
        IsValidDemo demo = new IsValidDemo();
        System.out.println(demo.isValid("()[]{}}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character peek = stack.peek();
                if (peek == '(' && c == ')') {
                    stack.pop();
                } else if (peek == '{' && c == '}') {
                    stack.pop();
                } else if (peek == '[' && c == ']') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
