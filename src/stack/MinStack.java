package stack;

import java.util.Stack;

/**
 * 155. 最小栈
 * <p>
 * https://leetcode.cn/problems/min-stack/
 */
class MinStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.push(x);
        }
    }

    public void pop() {
        if (stack1.isEmpty()) {
            return;
        }
        Integer pop = stack1.pop();
        if (!stack2.isEmpty() && pop.equals(stack2.peek())) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.isEmpty() ? -1 : stack1.peek();
    }

    public int getMin() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return stack1.isEmpty() ? -1 : stack1.peek();
    }
}